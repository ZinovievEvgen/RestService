package helback.dao_impl;

import helback.dao_abstract.TranslationSectionDao;
import helback.models.TranslationSection;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class TranslationSectionDaoImpl extends AbstractDao<Long, TranslationSection> implements TranslationSectionDao {
    @Override
    public Optional<TranslationSection> getTranslationByIdOfSectionAndIdOfLang(Long idOfSection, String idOfLang) {
        String query = "select t from TranslationSection t join t.section ta where ta.id = :idOfSection and t.lang = :idOfLang";
        return entityManager.unwrap(Session.class)
                .createQuery(query, TranslationSection.class)
                .setParameter("idOfSection", idOfSection)
                .setParameter("idOfLang", idOfLang)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public List<TranslationSection> getAllTranslationSectionByIdSection(Long idOfSection) {
        return (List<TranslationSection>) entityManager.createQuery("select distinct t from TranslationSection t join t.section a where a.id = :idOfSection").setParameter("idOfSection", idOfSection).getResultList();
    }
}