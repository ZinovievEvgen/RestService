package helback.service;

import helback.dto.ServiceAndItemsDTO;
import helback.models.ServicesAndItems;

import java.util.List;

public interface ServicesAndItemsService {

    ServiceAndItemsDTO getServicesAndItemsById(Long id);

    void addServicesAndItemsWithIdSection(ServiceAndItemsDTO serviceAndItemsDTO, Long id);

    void addServicesAndItemsDTO(ServiceAndItemsDTO servicesAndItemsDTO);

    List<ServiceAndItemsDTO> getAllServicesAndItems();

    void deleteServicesAndItemsById(Long id);

    void updateServicesAndItems(ServiceAndItemsDTO servicesAndItemsDTO);

    List<ServicesAndItems> getServicesAndItemsByLocation(String location);

    List<ServiceAndItemsDTO> getServicesAndItemsBySection(Long idSection);

}
