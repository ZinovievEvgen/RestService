package helback.service_impl;

import helback.dao_abstract.CompleteListTaskDao;
import helback.dao_abstract.PersonDao;
import helback.dao_abstract.TaskDao;
import helback.dto.PersonDTO;
import helback.dto.TaskDTO;
import helback.exception.EmptyAllowListTaskException;
import helback.exception.PersonNotFoundException;
import helback.exception.UniqueIdAlreadyExistException;
import helback.mapper.PersonMapper;
import helback.mapper.TaskMapper;
import helback.models.CompleteListTask;
import helback.models.Person;
import helback.models.Task;
import helback.service.PersonService;
import helback.service.TranslationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности Person
 * <p>
 * getAllowTaskList(Long id) - Выводит список всех доступных тасков у пользователя
 * updateAllowTaskList(Long idOfPerson, Long idOfTask) - Добавляет задачу к списку доступных тасков у пользователя
 * checkStatusOfAllowTask(Long idOfPerson, Long idOfTask) - Удаляет задачу из листа доступных тасков, в момент заполнения complete-time
 * setAllowTaskForPerson() - устанавливает список доступных задач пользователям (общий список для всех)
 * readerIdTask() - считывает ид задач из файла (путь в проперти)
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Value("${PATH_FROM_FILE}")
    private String fromFile;

    @Value("${PATH_FROM_FILE_YEA}")
    private String fromFileY;

    private final PersonDao personDao;
    private final TaskDao taskDao;
    private final PersonMapper personMapper;
    private final TranslationTaskService translationTaskService;
    private final CompleteListTaskDao completeListTaskDao;
    private final TaskMapper taskMapper;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, TaskDao taskDao,
                             PersonMapper personMapper, TranslationTaskService translationTaskService, CompleteListTaskDao completeListTaskDao, TaskMapper taskMapper) {
        this.personDao = personDao;
        this.taskDao = taskDao;
        this.personMapper = personMapper;
        this.translationTaskService = translationTaskService;
        this.completeListTaskDao = completeListTaskDao;
        this.taskMapper = taskMapper;
    }

    @Override
    public boolean getExistPerson(String uniqueId) {
        return personDao.findPersonByUniqueId(uniqueId).isPresent();
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.getByKey(id);
    }

    @Override
    public PersonDTO getPersonDTOById(Long id) {
        return personMapper.toDto(personDao.getByKey(id));
    }

    @Override
    public Person getPersonByUniqueId(String uniqueId) {
        return personDao.getPersonByUniqueId(uniqueId);
    }

    @Override
    public void addPerson(PersonDTO personDTO) throws Exception {
        try {
            Person person = personMapper.toEntity(personDTO);
            person.setHealPoint(70L);
            person.setMedPoint(50L);
            person.setAllowTaskList(joinLists(setAllowTaskForPerson(fromFile), setAllowTaskForPerson(fromFileY)));
            personDao.persist(person);
        } catch (UniqueIdAlreadyExistException u) {
            System.out.println("Уникальный id уже используется");
            throw new UniqueIdAlreadyExistException();
        } catch (Exception ex) {
            System.out.println("Ошибка при добавлении пользователя!");
            throw new Exception();
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return personDao.getAll();
    }

    @Override
    public void deletePersonById(Long id) {
        try {
            personDao.deleteByKey(id);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении пользователя");
        }
    }

    @Override
    public void updatePerson(Person person) {
        try {
            personDao.update(person);
        } catch (Exception e) {
            System.out.println("Ошибка при обновлениии пользвоателя");
        }
    }

    @Override
    public List<TaskDTO> getAllowTaskList(Long id, String lang) {
        try {
            Person currentPerson = personDao.getByKey(id);
            return changeCountFriendForTask(currentPerson);
        } catch (EmptyAllowListTaskException e) {
            throw new EmptyAllowListTaskException();
        }
    }

    @Override
    public List<TaskDTO> getAllowTaskListAnother(String uniqueId, String lang) {
        try {
            Person currentPersonUnique = personDao.findPersonByUniqueId(uniqueId).orElseThrow(PersonNotFoundException::new);
            /*
              Это доступ по уникальному ид пользователя без проверки
              Person currentPersonUnique = personDao.getPersonByUniqueId(uniqueId);
             */
            return changeCountFriendForTask(currentPersonUnique);
        } catch (EmptyAllowListTaskException e) {
            System.out.println(e.getMessage());
            throw new EmptyAllowListTaskException();
        }
    }

    @Override
    public List<Task> setAllowTaskForPerson(String path) {
        List<Long> resultListWithIdTask = readerIdTask(path);
        List<Task> allowTask = new ArrayList<>();

        for (int i = 0; i < resultListWithIdTask.size(); i++) {
            allowTask.add(taskDao.getByKey(resultListWithIdTask.get(i)));
        }
        return allowTask;
    }

    @Override
    public List<TaskDTO> completeTaskByPerson(String uniqueId) {
        return taskMapper.toDto(completeListTaskDao.getAllCompleteTaskByPerson(personDao.getPersonByUniqueId(uniqueId).getId()));
    }

    @Override
    public <T> ArrayList<T> joinLists(List<? extends T> listA, List<? extends T> listB) {
        boolean aEmpty = (listA == null) || listA.isEmpty();
        boolean bEmpty = (listB == null) || listB.isEmpty();
        //побитное И!
        if (aEmpty & bEmpty) {
            // оба пустые — отдаем новый пустой список
            return new ArrayList<>();
        } else if (aEmpty) {
            // один пустой — отдаем копию другого, содержащую все его элементы
            return new ArrayList<T>(listB);
        } else if (bEmpty) {
            return new ArrayList<T>(listA);
        } else {
            // оба непустые — объединяем
            ArrayList<T> result = new ArrayList<T>(
                    listA.size() + listB.size());
            result.addAll(listA);
            result.addAll(listB);
            return result;
        }
    }

    @Override
    public void addTaskOnAllowTaskList(Long idOfPerson, String path) {
        try {
            Person currentPerson = personDao.getByKey(idOfPerson);
            currentPerson.setAllowTaskList(joinLists(currentPerson.getAllowTaskList(), setAllowTaskForPerson(path)));
            personDao.update(currentPerson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлениии списка доступных задач пользвоателя");
        }
    }

    @Override
    public void deleteTaskOnAllowTaskList(Person currentPerson, Task deleteTask) {
        try {
            for (int i = 0; i < currentPerson.getAllowTaskList().size(); i++) {
                if (currentPerson.getAllowTaskList().get(i).getId().equals(deleteTask.getId())) {
                    currentPerson.getAllowTaskList().remove(i);
                    break;
                }
            }
            personDao.update(currentPerson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при удалении задачи из списка доступных у пользователя");
        }
    }

    @Override
    public void clearCompleteTaskList(Person person, Task deleteTask) {
        try {
            completeListTaskDao.deleteByPersonAndTask(person, deleteTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при удалении задачи из списка выполненных у пользователя");
        }
    }

    @Override
    public void updateHealtyPointByPerson(Person person, List<Task> haveAllowTaskList) {


        Long healtyPoint = person.getHealPoint();
        System.out.println("Начальний уровень healty point : " + healtyPoint + " У пользователя: " + person.getUniqueId());

        if (healtyPoint > 0) {
            for (int i = 0; i < haveAllowTaskList.size(); i++) {
                if (healtyPoint > 0) {
                    healtyPoint -= haveAllowTaskList.get(i).getHealLevel();
                } else {
                    break;
                }
            }
            person.setHealPoint(healtyPoint);
            personDao.update(person);
            System.out.println("Уровень HealtyPoint у Пользователя: " + person.getUniqueId() + " изменен и равен: " + person.getHealPoint());

        } else {
            System.out.println("Уровень HealtyPoint у Пользователя: " + person.getUniqueId() + " равен 0!");
        }
    }

    @Override
    public List<PersonDTO> getFriends(String uniqueId) {
        List<Person> mainList = new ArrayList<>(personDao.getPersonByUniqueId(uniqueId).getFriends());
        return personMapper.toDto(mainList);
    }

    @Override
    public Long findFriend(Long idTask, Person person) {
        List<CompleteListTask> currentCompleteTaskList = completeListTaskDao.getAllCompleteTaskByIdTask(idTask);
        Set<Person> friendList = person.getFriends();
        Long countFriend = 0L;

        for (int q = 0; q < currentCompleteTaskList.size(); q++) {
            for (Person p : friendList) {
                if (p.equals(currentCompleteTaskList.get(q).getPerson())) {
                    countFriend++;
                }
            }
        }
        return countFriend;
    }

    @Override
    public List<TaskDTO> changeCountFriendForTask(Person person) {
        List<TaskDTO> currentTaskList = taskMapper.toDto(person.getAllowTaskList());

        Long countUnique;

        for (int i = 0; i < currentTaskList.size(); i++) {
            countUnique = findFriend(currentTaskList.get(i).getId(), person);
            currentTaskList.get(i).setCountFriend(countUnique);
        }

        return currentTaskList;
    }

    //передавать переменнную путь - и вызывать метод на дневные такси и на годовые
    @Override
    public List<Long> readerIdTask(String path) {

        List<Long> idToCommonTask = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            try (BufferedReader reader = new BufferedReader(fr)) {
                String line = reader.readLine();
                while (line != null) {
                    line = line.replaceAll("[^0-9]", "");
                    Long bufferNumber = Long.valueOf(line);
                    idToCommonTask.add(bufferNumber);
                    // считываем остальные строки в цикле
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при чтении файла с id доступных задач для пользователя");
        }
        return idToCommonTask;
    }
}
