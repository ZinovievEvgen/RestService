package helback.dao_impl;

import helback.dao_abstract.TranslationTaskDao;
import helback.models.TranslationTask;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class TranslationTaskDaoImpl extends AbstractDao<Long, TranslationTask> implements TranslationTaskDao {

    @Override
    public Optional<TranslationTask> getTranslationTaskByIdOfTaskAndIdOfLang(Long idOfTask, String idOfLang) {
        String query = "select t from TranslationTask t join t.task ta where ta.id = :idOfTask and t.lang = :idOfLang";
        return entityManager.unwrap(Session.class)
                .createQuery(query, TranslationTask.class)
                .setParameter("idOfTask", idOfTask)
                .setParameter("idOfLang", idOfLang)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public List<TranslationTask> getAllTranslationTaskByIdTask(Long idOfTask) {
        return (List<TranslationTask>) entityManager.createQuery("select distinct t from TranslationTask t join t.task a where a.id = :idOfTask").setParameter("idOfTask", idOfTask).getResultList();
    }
}