package helback.dao_impl;

import helback.dao_abstract.SectionDao;
import helback.models.Section;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности Section
 */
@Transactional
@Repository
public class SectionDaoImpl extends AbstractDao<Long, Section> implements SectionDao {

    @Override
    public Optional<Section> getSectionByName(String description) {
        String query = "select s from Section s where s.description = :description";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Section.class)
                .setParameter("description", description)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public List<Section> getSectionsByStatus(String status) {
        return (List<Section>) entityManager.createQuery("select distinct s from Section s where s.status = :status").setParameter("status", status).getResultList();
    }
}
