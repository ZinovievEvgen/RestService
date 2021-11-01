package helback.service;

import helback.models.CompleteListTask;
import helback.models.Person;
import helback.models.Task;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Слой бизнес логики (Service)
 * интерфейс service для сущности CompleteListTaskService
 */
public interface CompleteListTaskService {

    CompleteListTask getCompleteListTaskById(Long id);

    void deleteCompleteListTaskById(Long id);

    void addCompleteListTask(CompleteListTask completeListTask);

    List<CompleteListTask> getAllCompleteListTask();

    void addCreateTimeTask(String uniqueId, Long idOfTask);

    void addCompleteTimeTask(String uniqueId, Long idOfTask);

    void updateCompleteListTask(CompleteListTask completeListTask);

    List<CompleteListTask> getAllOpenCompleteListTaskDaily(LocalDateTime start, LocalDateTime finish);

    List<Task> getAllOpenCompleteTaskByPerson(Long id, LocalDateTime start, LocalDateTime finish);

    List<Task> getAllCompleteTaskByPerson(Long id);

    void deleteByPersonAndTask(Person person, Task task);
}
