package helback.dao_impl;

import helback.dao_abstract.CompleteListTaskDao;
import helback.models.CompleteListTask;
import helback.models.Person;
import helback.models.Task;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


/**
 * Слой ДАО
 * класс реализация ДАО для сущности CompleteListTaskService
 */
@Transactional
@Repository
public class CompleteListTaskDaoImpl extends AbstractDao<Long, CompleteListTask> implements CompleteListTaskDao {
    @Override
    public Long getMaxIdByCompleteListTask(Person person, Task task) {
        return (Long) entityManager.createQuery("select MAX(id) from CompleteListTask c where c.person = :person and c.task = :task")
                .setParameter("person", person)
                .setParameter("task", task)
                .getSingleResult();
    }

    @Override
    public List<Task> getAllCompleteTaskByPerson(Long id) {
        return (List<Task>) entityManager.createQuery("select c.task from CompleteListTask c join c.person p where p.id = :idOfPerson and c.completeDate is not null")
                .setParameter("idOfPerson", id)
                .getResultList();
    }

    @Override
    public List<Task> getAllOpenCompleteTaskByPerson(Long id, LocalDateTime start, LocalDateTime finish) {
        return (List<Task>) entityManager.createQuery("select c.task from CompleteListTask c join c.person p where p.id = :idOfPerson and c.createDate >= :start and c.createDate < :finish and c.completeDate is null")
                .setParameter("idOfPerson", id)
                .setParameter("start", start)
                .setParameter("finish", finish)
                .getResultList();
    }

    @Override
    public Optional<Long> checkDoubleStart(Person person, Task task) {
        String query = "select MAX(id) from CompleteListTask c where c.person = :person and c.task = :task";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Long.class)
                .setParameter("person", person)
                .setParameter("task", task)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public List<CompleteListTask> getAllOpenCompleteListTaskDaily(LocalDateTime start, LocalDateTime finish) {
        return (List<CompleteListTask>) entityManager.createQuery("select c from CompleteListTask c where c.createDate between :start and :finish order by c.createDate")
                .setParameter("start", start)
                .setParameter("finish", finish)
                .getResultList();
    }

    @Override
    public void deleteByPersonAndTask(Person person, Task task) {
        entityManager.createQuery("delete from CompleteListTask c where c.person = :person and c.task = :task")
                .setParameter("person", person)
                .setParameter("task", task)
                .executeUpdate();
    }

    @Override
    public List<CompleteListTask> getAllCompleteTaskByIdTask(Long idTask) {
        return entityManager.createQuery("select c from CompleteListTask c where c.task.id = :idTask and c.completeDate is not null")
                .setParameter("idTask", idTask)
                .getResultList();
    }
}