package helback.service_impl;

import helback.dao_abstract.CompleteListTaskDao;
import helback.dao_abstract.PersonDao;
import helback.dao_abstract.TaskDao;
import helback.exception.DoubleStartTaskException;
import helback.exception.NullRequestParametrException;
import helback.models.CompleteListTask;
import helback.models.Person;
import helback.models.Task;
import helback.service.CompleteListTaskService;
import helback.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности CompleteListTask
 */
@Service
public class CompleteListTaskServiceImpl implements CompleteListTaskService {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss");


    private final CompleteListTaskDao completeListTaskDao;
    private final PersonDao personDao;
    private final TaskDao taskDao;
    private final PersonService personService;

    @Autowired
    public CompleteListTaskServiceImpl(CompleteListTaskDao completeListTaskDao, PersonDao personDao, TaskDao taskDao, PersonService personService) {
        this.completeListTaskDao = completeListTaskDao;
        this.personDao = personDao;
        this.taskDao = taskDao;
        this.personService = personService;
    }

    @Override
    public CompleteListTask getCompleteListTaskById(Long id) {
        return completeListTaskDao.getByKey(id);
    }

    @Override
    public void deleteCompleteListTaskById(Long id) {
        try {
            completeListTaskDao.deleteByKey(id);
        } catch (Exception e) {
            System.out.println("Ошибка при удалении сущности CompleteListTask");
        }
    }

    @Override
    public void addCompleteListTask(CompleteListTask completeListTask) {
        try {
            completeListTaskDao.persist(completeListTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении сущности CompleteListTask");
        }
    }

    @Override
    public List<CompleteListTask> getAllCompleteListTask() {
        return completeListTaskDao.getAll();
    }

    @Override
    public void addCreateTimeTask(String uniqueId, Long idOfTask) {

        if (existA(idOfTask)) {
            try {
                Person person1 = personDao.getPersonByUniqueId(uniqueId);
                Task task1 = taskDao.getByKey(idOfTask);
                String createDateTime = LocalDateTime.now().format(formatter);
                Optional<Long> current = completeListTaskDao.checkDoubleStart(person1, task1);
                if (!current.isPresent()) {
                    completeListTaskDao.persist(new CompleteListTask(person1, LocalDateTime.parse(createDateTime, formatter), task1));
                } else {
                    throw new DoubleStartTaskException();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Ошибка при добавлении времени начала выполнения задачи");
            }
        } else {
            throw new NullRequestParametrException();
        }
    }

    @Override
    public void addCompleteTimeTask(String uniqueId, Long idOfTask) {
        try {
            Person personOld = personDao.getPersonByUniqueId(uniqueId);
            Task taskChange = taskDao.getByKey(idOfTask);
            String completeDateTime = LocalDateTime.now().format(formatter);

            Long idCompleteListTask = completeListTaskDao.getMaxIdByCompleteListTask(personOld, taskChange);
            CompleteListTask bufferCompleteListTAsk = completeListTaskDao.getByKey(idCompleteListTask);
            bufferCompleteListTAsk.setCompleteDate(LocalDateTime.parse(completeDateTime, formatter));
            completeListTaskDao.update(bufferCompleteListTAsk);

            if (personOld.getHealPoint() < 100) {
                Long bufferHeal = personOld.getHealPoint();
                bufferHeal += taskChange.getHealLevel();
                personOld.setHealPoint(bufferHeal);
            } else {
                Long bufferMedChange = personOld.getMedPoint();
                bufferMedChange += taskChange.getMedLevel();
                personOld.setMedPoint(bufferMedChange);
            }

            Long bufferMed = personOld.getMedPoint();
            bufferMed += taskChange.getMedLevel();
            personOld.setMedPoint(bufferMed);

            Long bufferQuantity = taskChange.getQuantitySuccess() + 1;
            taskChange.setQuantitySuccess(bufferQuantity);
            taskDao.update(taskChange);
            personDao.update(personOld);

            personService.deleteTaskOnAllowTaskList(personOld, taskChange);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении времени окончания выполнения задачи");
        }
    }

    @Override
    public void updateCompleteListTask(CompleteListTask completeListTask) {
        try {
            completeListTaskDao.update(completeListTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении сущности CompleteListTask");
        }
    }

    @Override
    public List<CompleteListTask> getAllOpenCompleteListTaskDaily(LocalDateTime start, LocalDateTime finish) {
        return completeListTaskDao.getAllOpenCompleteListTaskDaily(start, finish);
    }

    @Override
    public List<Task> getAllOpenCompleteTaskByPerson(Long id, LocalDateTime start, LocalDateTime finish) {
        return completeListTaskDao.getAllOpenCompleteTaskByPerson(id, start, finish);
    }

    @Override
    public List<Task> getAllCompleteTaskByPerson(Long id) {
        return completeListTaskDao.getAllCompleteTaskByPerson(id);
    }

    @Override
    public void deleteByPersonAndTask(Person person, Task task) {
        completeListTaskDao.deleteByPersonAndTask(person, task);
    }

    private boolean existA(Long idOfTask) {
        List<Task> tasks = taskDao.getAll();

        for (int i = 0; i < tasks.size(); i++) {
            if (idOfTask.equals(tasks.get(i).getId())) {
                return true;
            }
        }
        return false;
    }
}
