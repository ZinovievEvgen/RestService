package helback.service_impl;

import helback.dao_abstract.ServicesAndItemsDao;
import helback.dto.ServiceAndItemsDTO;
import helback.mapper.ServiceAndItemsMapper;
import helback.models.ServicesAndItems;
import helback.service.SectionService;
import helback.service.ServicesAndItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности ServicesAndItems
 */
@Service
public class ServicesAndItemsServiceImpl implements ServicesAndItemsService {

    private final ServicesAndItemsDao servicesAndItemsDao;
    private final SectionService sectionService;
    private final ServiceAndItemsMapper serviceAndItemsMapper;

    @Autowired
    public ServicesAndItemsServiceImpl(ServicesAndItemsDao servicesAndItemsDao, SectionService sectionService, ServicesAndItemsDao servicesAndItemsDao1, SectionService sectionService1, ServiceAndItemsMapper serviceAndItemsMapper) {
        this.servicesAndItemsDao = servicesAndItemsDao1;
        this.sectionService = sectionService1;
        this.serviceAndItemsMapper = serviceAndItemsMapper;
    }

    @Override
    public ServiceAndItemsDTO getServicesAndItemsById(Long id) {
        return serviceAndItemsMapper.toDto(servicesAndItemsDao.getByKey(id));
    }

    @Override
    public void addServicesAndItemsWithIdSection(ServiceAndItemsDTO serviceAndItemsDTO, Long id) {
        // на всякий случай
    }

    @Override
    public void addServicesAndItemsDTO(ServiceAndItemsDTO servicesAndItemsDTO) {
        servicesAndItemsDao.persist(serviceAndItemsMapper.toEntity(servicesAndItemsDTO));
    }

    @Override
    public List<ServiceAndItemsDTO> getAllServicesAndItems() {
        return serviceAndItemsMapper.toDto(servicesAndItemsDao.getAll());
    }

    @Override
    public void deleteServicesAndItemsById(Long id) {
        servicesAndItemsDao.deleteByKey(id);
    }

    @Override
    public void updateServicesAndItems(ServiceAndItemsDTO servicesAndItemsDTO) {
        ServicesAndItems updateServicesAndItems = servicesAndItemsDao.getByKey(servicesAndItemsDTO.getId());
        updateServicesAndItems.setSection(sectionService.getSectionById(servicesAndItemsDTO.getSectionId()));
        serviceAndItemsMapper.updateEFromD(servicesAndItemsDTO, updateServicesAndItems);
        servicesAndItemsDao.update(updateServicesAndItems);


        servicesAndItemsDao.update(serviceAndItemsMapper.toEntity(servicesAndItemsDTO));
    }

    @Override
    public List<ServicesAndItems> getServicesAndItemsByLocation(String location) {
        return servicesAndItemsDao.getServicesAndItemsByLocation(location);
    }

    @Override
    public List<ServiceAndItemsDTO> getServicesAndItemsBySection(Long idSection) {
        return serviceAndItemsMapper.toDto(servicesAndItemsDao.getServicesAndItemsBySection(idSection));
    }
}
