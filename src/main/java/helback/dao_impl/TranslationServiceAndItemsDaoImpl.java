package helback.dao_impl;

import helback.dao_abstract.TranslationServiceAndItemsDao;
import helback.models.TranslationServiceAndItems;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class TranslationServiceAndItemsDaoImpl extends AbstractDao<Long, TranslationServiceAndItems> implements TranslationServiceAndItemsDao {
    @Override
    public Optional<TranslationServiceAndItems> getTranslationByIdOfServiceAndIdOfLang(Long idOfService, String idOfLang) {
        String query = "select t from TranslationServiceAndItems t join t.servicesAndItems ta where ta.id = :idOfService and t.lang = :idOfLang";
        return entityManager.unwrap(Session.class)
                .createQuery(query, TranslationServiceAndItems.class)
                .setParameter("idOfService", idOfService)
                .setParameter("idOfLang", idOfLang)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    // NotFoundTraslationException
    @Override
    public List<TranslationServiceAndItems> getAllTranslationServiceAndItemsByIdSection(Long idOfService) {
        return (List<TranslationServiceAndItems>) entityManager.createQuery("select distinct t from TranslationServiceAndItems t join t.servicesAndItems a where a.id = :idOfService").setParameter("idOfService", idOfService).getResultList();
    }
}
