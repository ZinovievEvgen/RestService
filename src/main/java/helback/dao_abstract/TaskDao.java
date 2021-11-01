package helback.dao_abstract;


import helback.models.Task;

import java.util.List;
import java.util.Optional;

/**
 * Слой ДАО
 * интерфейс ДАО для Task
 */
public interface TaskDao extends GenericDao<Long, Task> {

    List<Task> getTaskByType(Long id);

    Optional<Task> getTaskByOrdered(Long ordered);
}
