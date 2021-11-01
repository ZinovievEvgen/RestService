package helback.dao_impl;

import helback.dao_abstract.ServicesAndItemsDao;
import helback.models.ServicesAndItems;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности ServicesAndItems
 */
@Transactional
@Repository
public class ServicesAndItemsDaoImpl extends AbstractDao<Long, ServicesAndItems> implements ServicesAndItemsDao {

    @Override
    public List<ServicesAndItems> getServicesAndItemsByLocation(String location) {
        return (List<ServicesAndItems>) entityManager.createQuery("select s from ServicesAndItems s where s.location = :location").setParameter("location", location).getResultList();
    }

    @Override
    public List<ServicesAndItems> getServicesAndItemsBySection(Long idSection) {
        return (List<ServicesAndItems>) entityManager.createQuery("select s from ServicesAndItems s join s.section se where se.id = :idSection").setParameter("idSection", idSection).getResultList();
    }
}
