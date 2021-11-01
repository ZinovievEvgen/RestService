package helback.dao_abstract;

import helback.models.CompleteListTask;
import helback.models.Person;
import helback.models.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * Слой ДАО
 * интерфейс ДАО для CompleteListTaskService
 */
public interface CompleteListTaskDao extends GenericDao<Long, CompleteListTask> {

    Long getMaxIdByCompleteListTask(Person person, Task task);

    List<Task> getAllCompleteTaskByPerson(Long id);

    List<Task> getAllOpenCompleteTaskByPerson(Long id, LocalDateTime start, LocalDateTime finish);

    Optional<Long> checkDoubleStart(Person person, Task task);

    List<CompleteListTask> getAllOpenCompleteListTaskDaily(LocalDateTime start, LocalDateTime finish);

    void deleteByPersonAndTask(Person person, Task task);

    List<CompleteListTask> getAllCompleteTaskByIdTask(Long idTask);
}
