package helback.service_impl;

import helback.dao_abstract.CompleteListTaskDao;
import helback.dao_abstract.PersonDao;
import helback.dao_abstract.TranslationTaskDao;
import helback.dto.TaskDTO;
import helback.dto.TranslationTaskDTO;
import helback.exception.NotFoundTraslationException;
import helback.exception.PersonNotFoundException;
import helback.mapper.TaskMapper;
import helback.mapper.TranslationTaskMapper;
import helback.models.CompleteListTask;
import helback.models.Person;
import helback.models.Task;
import helback.models.TranslationTask;
import helback.service.TaskService;
import helback.service.TranslationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TranslationTaskServiceImpl implements TranslationTaskService {

    private final TranslationTaskDao translationTaskDao;
    private final PersonDao personDao;
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final CompleteListTaskDao completeListTaskDao;
    private final TranslationTaskMapper translationTaskMapper;

    @Autowired
    public TranslationTaskServiceImpl(TranslationTaskDao translationTaskDao, PersonDao personDao, TaskService taskService, TaskMapper taskMapper, CompleteListTaskDao completeListTaskDao, TranslationTaskMapper translationTaskMapper) {
        this.translationTaskDao = translationTaskDao;
        this.personDao = personDao;
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.completeListTaskDao = completeListTaskDao;
        this.translationTaskMapper = translationTaskMapper;
    }

    @Override
    public TranslationTask getTranslationTaskById(Long id) {
        return translationTaskDao.getByKey(id);
    }

    @Override
    public TranslationTaskDTO getTranslationTaskDTOById(Long id) {
        return translationTaskMapper.toDto(translationTaskDao.getByKey(id));
    }

    @Override
    public List<TranslationTask> getAllTranslationTaskByIdTask(Long idOfTask) {
        return translationTaskDao.getAllTranslationTaskByIdTask(idOfTask);
    }

    @Override
    public List<TaskDTO> getTranslationTaskByLangAndTaskForUnPerson(String uniqueId, String lang) throws NotFoundTraslationException, PersonNotFoundException {

        /*
          Это доступ по уникальному ид пользователя без проверки
          Person currentPerson = personDao.getPersonByUniqueId(uniqueId);
         */
        Person currentPerson = personDao.findPersonByUniqueId(uniqueId).orElseThrow(PersonNotFoundException::new);
        List<Task> allowListTask = currentPerson.getAllowTaskList();
        try {
            return translateTask(allowListTask, lang, currentPerson);
        } catch (NotFoundTraslationException e) {
            throw new NotFoundTraslationException();
        }
    }

    @Override
    public List<TaskDTO> getTranslationTaskByLangAndTaskForPerson(Long id, String lang) throws NotFoundTraslationException {
        Person currentPerson = personDao.getByKey(id);
        List<Task> allowListTask = currentPerson.getAllowTaskList();
        try {
            return translateTask(allowListTask, lang, currentPerson);
        } catch (NotFoundTraslationException e) {
            throw new NotFoundTraslationException();
        }
    }

    @Override
    public List<TaskDTO> getTranslationCompleteTaskByLangAndTaskForUnPerson(String uniqueId, String lang) throws NotFoundTraslationException {
        Person currentPerson = personDao.getPersonByUniqueId(uniqueId);
        List<Task> completeListTask = completeListTaskDao.getAllCompleteTaskByPerson(currentPerson.getId());
        try {
            return translateTask(completeListTask, lang, currentPerson);
        } catch (NotFoundTraslationException e) {
            throw new NotFoundTraslationException();
        }
    }

    @Override
    public List<TranslationTask> getAll() {
        return translationTaskDao.getAll();
    }

    @Override
    public List<TranslationTaskDTO> getAllDTO() {
        return translationTaskMapper.toDto(translationTaskDao.getAll());
    }

    @Override
    public TaskDTO getTaskByIdWithLang(Long id, String lang) throws NotFoundTraslationException {
        TaskDTO currentTaskDTO = taskMapper.toDto(taskService.getTaskById(id));
        TranslationTask currentTranslateTask = translationTaskDao.getTranslationTaskByIdOfTaskAndIdOfLang(id, lang).orElseThrow(NotFoundTraslationException::new);
        currentTaskDTO.setDescription(currentTranslateTask.getDescriptionLang());
        currentTaskDTO.setRecommendation(currentTranslateTask.getRecommendationLang());
        currentTaskDTO.setViewLinks(currentTranslateTask.getViewLinksLang());
        return currentTaskDTO;
    }

    @Override
    public void addTranslationTaskDTO(TranslationTaskDTO translationTaskDTO) {
        try {
            TranslationTask translationTask = translationTaskMapper.toEntity(translationTaskDTO);
            translationTaskDao.persist(translationTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении задачи");
        }
    }

    @Override
    public void deleteTranslationTaskById(Long id) {
        translationTaskDao.deleteByKey(id);
    }

    @Override
    public void updateTranslationTask(TranslationTaskDTO translationTaskDTO) {
        try {
            TranslationTask updateTranslationTask = translationTaskDao.getByKey(translationTaskDTO.getId());
            updateTranslationTask.setTask(taskService.getTaskById(translationTaskDTO.getTaskId()));
            translationTaskMapper.updateEFromD(translationTaskDTO, updateTranslationTask);
            translationTaskDao.update(updateTranslationTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении перевода задачи");
        }
    }

    private List<TaskDTO> translateTask(List<Task> allowListTask, String lang, Person person) throws NotFoundTraslationException {
        try {
            List<TaskDTO> localeTranslateAllowListTask = new ArrayList<>();
            List<CompleteListTask> currentCompleteTaskList;
            for (int i = 0; i < allowListTask.size(); i++) {
                TaskDTO currentTaskDTO = taskMapper.toDto(allowListTask.get(i));
                currentCompleteTaskList = completeListTaskDao.getAllCompleteTaskByIdTask(currentTaskDTO.getId());
                Set<Person> friendList = person.getFriends();
                Long countFriend = 0L;


                TranslationTask currentTranslateTask = translationTaskDao.getTranslationTaskByIdOfTaskAndIdOfLang(allowListTask.get(i).getId(), lang).orElseThrow(NotFoundTraslationException::new);
                currentTaskDTO.setDescription(currentTranslateTask.getDescriptionLang());
                currentTaskDTO.setRecommendation(currentTranslateTask.getRecommendationLang());
                currentTaskDTO.setViewLinks(currentTranslateTask.getViewLinksLang());

                for (int q = 0; q < currentCompleteTaskList.size(); q++) {
                    for (Person p : friendList) {
                        if (p.equals(currentCompleteTaskList.get(q).getPerson())) {
                            countFriend++;
                        }
                    }
                }

                currentTaskDTO.setCountFriend(countFriend);

                localeTranslateAllowListTask.add(currentTaskDTO);
            }
            return localeTranslateAllowListTask;
        } catch (NotFoundTraslationException n) {
            throw new NotFoundTraslationException();
        }
    }
}
