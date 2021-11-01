package helback.service_impl;

import helback.dao_abstract.ServicesAndItemsDao;
import helback.dao_abstract.TranslationServiceAndItemsDao;
import helback.dto.ServiceAndItemsDTO;
import helback.dto.TranslationServiceAndItemsDTO;
import helback.exception.NotFoundTraslationException;
import helback.mapper.ServiceAndItemsMapper;
import helback.mapper.TranslationServiceAndItemsMapper;
import helback.models.ServicesAndItems;
import helback.models.TranslationServiceAndItems;
import helback.service.TranslationServiceAndItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationServiceAndItemsServiceImpl implements TranslationServiceAndItemsService {

    private final TranslationServiceAndItemsDao translationServiceAndItemsDao;
    private final ServicesAndItemsDao servicesAndItemsDao;
    private final ServiceAndItemsMapper servicesAndItemsMapper;
    private final TranslationServiceAndItemsMapper translationServiceAndItemsMapper;

    @Autowired
    public TranslationServiceAndItemsServiceImpl(TranslationServiceAndItemsDao translationServiceAndItemsDao, ServicesAndItemsDao servicesAndItemsDao, ServiceAndItemsMapper servicesAndItemsMapper, TranslationServiceAndItemsMapper translationServiceAndItemsMapper) {
        this.translationServiceAndItemsDao = translationServiceAndItemsDao;
        this.servicesAndItemsDao = servicesAndItemsDao;
        this.servicesAndItemsMapper = servicesAndItemsMapper;
        this.translationServiceAndItemsMapper = translationServiceAndItemsMapper;
    }


    @Override
    public List<ServiceAndItemsDTO> getTranslationByIdOfServiceAndIdOfLang(Long idOfService, String lang) throws NotFoundTraslationException {
        List<ServicesAndItems> listServicesAndItems = servicesAndItemsDao.getServicesAndItemsBySection(idOfService);
        try {
            return translateServicesAndItems(listServicesAndItems, lang);
        } catch (NotFoundTraslationException e) {
            throw new NotFoundTraslationException();
        }
    }

    @Override
    public List<TranslationServiceAndItems> getAllTranslationServiceAndItemsByIdService(Long idOfService) {
        return translationServiceAndItemsDao.getAllTranslationServiceAndItemsByIdSection(idOfService);
    }

    @Override
    public TranslationServiceAndItemsDTO getTranslationServiceAndItemsById(Long id) {
        return translationServiceAndItemsMapper.toDto(translationServiceAndItemsDao.getByKey(id));
    }

    @Override
    public List<TranslationServiceAndItemsDTO> getAll() {
        return translationServiceAndItemsMapper.toDto(translationServiceAndItemsDao.getAll());
    }

    @Override
    public void addTranslationServiceAndItems(TranslationServiceAndItemsDTO translationServiceAndItemsDTO) {
        try {
            translationServiceAndItemsDao.persist(translationServiceAndItemsMapper.toEntity(translationServiceAndItemsDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении сущности");
        }
    }

    @Override
    public void deleteTranslationServiceAndItemsById(Long id) {
        translationServiceAndItemsDao.deleteByKey(id);
    }

    @Override
    public void updateTranslationServiceAndItems(TranslationServiceAndItemsDTO translationServiceAndItemsDTO) {
        try {
            TranslationServiceAndItems updateTranslationServiceAndItems = translationServiceAndItemsDao.getByKey(translationServiceAndItemsDTO.getId());
            updateTranslationServiceAndItems.setServicesAndItems(servicesAndItemsDao.getByKey(translationServiceAndItemsDTO.getServiceId()));
            translationServiceAndItemsMapper.updateEFromD(translationServiceAndItemsDTO, updateTranslationServiceAndItems);
            translationServiceAndItemsDao.update(updateTranslationServiceAndItems);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении сущности");
        }
    }

    @Override
    public TranslationServiceAndItems getTranslationByIdOfServiceAndIdOfLangSingle(Long idOfService, String idOfLang) throws NotFoundTraslationException {
        return translationServiceAndItemsDao.getTranslationByIdOfServiceAndIdOfLang(idOfService, idOfLang).orElseThrow(NotFoundTraslationException::new);
    }

    @Override
    public ServiceAndItemsDTO getTranslateTranslationServiceAndItemsById(Long idService, String lang) throws NotFoundTraslationException {
        return singleTranslateService(idService, lang);
    }

    private List<ServiceAndItemsDTO> translateServicesAndItems(List<ServicesAndItems> listServicesAndItems, String lang) throws NotFoundTraslationException {
        try {
            List<ServiceAndItemsDTO> localeTranslateServicesAndItemsList = new ArrayList<>();
            for (int i = 0; i < listServicesAndItems.size(); i++) {
                ServiceAndItemsDTO currentServicesAndItemsDTO = servicesAndItemsMapper.toDto(listServicesAndItems.get(i));
                TranslationServiceAndItems currentTranslationServiceAndItems = translationServiceAndItemsDao.getTranslationByIdOfServiceAndIdOfLang(listServicesAndItems.get(i).getId(), lang).orElseThrow(NotFoundTraslationException::new);
                currentServicesAndItemsDTO.setDescription(currentTranslationServiceAndItems.getDescriptionLang());
                currentServicesAndItemsDTO.setViewLinks(currentTranslationServiceAndItems.getViewLinksLang());
                currentServicesAndItemsDTO.setLocation(currentTranslationServiceAndItems.getLocationLang());
                localeTranslateServicesAndItemsList.add(currentServicesAndItemsDTO);
            }
            return localeTranslateServicesAndItemsList;
        } catch (NotFoundTraslationException n) {
            throw new NotFoundTraslationException();
        }
    }

    private ServiceAndItemsDTO singleTranslateService(Long id, String lang) throws NotFoundTraslationException {
        try {
            ServiceAndItemsDTO currentServicesAndItemsDTO = servicesAndItemsMapper.toDto(servicesAndItemsDao.getByKey(id));
            TranslationServiceAndItems currentTranslationSection = translationServiceAndItemsDao.getTranslationByIdOfServiceAndIdOfLang(id, lang).orElseThrow(NotFoundTraslationException::new);
            currentServicesAndItemsDTO.setDescription(currentTranslationSection.getDescriptionLang());
            currentServicesAndItemsDTO.setViewLinks(currentTranslationSection.getViewLinksLang());
            currentServicesAndItemsDTO.setLocation(currentTranslationSection.getLocationLang());
            return currentServicesAndItemsDTO;
        } catch (
                NotFoundTraslationException n) {
            throw new NotFoundTraslationException();
        }
    }
}
