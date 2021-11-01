package helback.dao_abstract;

import helback.models.ServicesAndItems;

import java.util.List;

public interface ServicesAndItemsDao extends GenericDao<Long, ServicesAndItems> {

    List<ServicesAndItems> getServicesAndItemsByLocation(String location);

    List<ServicesAndItems> getServicesAndItemsBySection(Long idSection);
}
