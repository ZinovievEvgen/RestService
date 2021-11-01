package helback.dao_impl;

import helback.dao_abstract.TaskDao;
import helback.models.Task;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности Task
 */
@Transactional
@Repository
public class TaskDaoImpl extends AbstractDao<Long, Task> implements TaskDao {

    @Override
    public List<Task> getTaskByType(Long id) {
        return (List<Task>) entityManager.createQuery("select distinct t from Task t join t.taskType ta where ta.id = :idOfType").setParameter("idOfType", id).getResultList();
    }

    @Override
    public Optional<Task> getTaskByOrdered(Long ordered) {
        String query = "select t from Task t where t.ordered = :ordered";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Task.class)
                .setParameter("ordered", ordered)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }


}
