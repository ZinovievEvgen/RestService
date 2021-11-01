package helback.service;

import helback.dto.ServiceAndItemsDTO;
import helback.dto.TranslationServiceAndItemsDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.TranslationServiceAndItems;

import java.util.List;

public interface TranslationServiceAndItemsService {

    List<ServiceAndItemsDTO> getTranslationByIdOfServiceAndIdOfLang(Long idOfService, String idOfLang) throws NotFoundTraslationException;

    List<TranslationServiceAndItems> getAllTranslationServiceAndItemsByIdService(Long idOfService);

    TranslationServiceAndItemsDTO getTranslationServiceAndItemsById(Long id);

    List<TranslationServiceAndItemsDTO> getAll();

    void addTranslationServiceAndItems(TranslationServiceAndItemsDTO translationServiceAndItemsDTO);

    void deleteTranslationServiceAndItemsById(Long id);

    void updateTranslationServiceAndItems(TranslationServiceAndItemsDTO translationServiceAndItemsDTO);

    TranslationServiceAndItems getTranslationByIdOfServiceAndIdOfLangSingle(Long idOfService, String idOfLang) throws NotFoundTraslationException;

    ServiceAndItemsDTO getTranslateTranslationServiceAndItemsById(Long idService, String lang) throws NotFoundTraslationException;
}
