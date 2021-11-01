package helback.dao_abstract;

import helback.models.TranslationServiceAndItems;

import java.util.List;
import java.util.Optional;

public interface TranslationServiceAndItemsDao extends GenericDao<Long, TranslationServiceAndItems> {

    Optional<TranslationServiceAndItems> getTranslationByIdOfServiceAndIdOfLang(Long idOfService, String idOfLang);

    List<TranslationServiceAndItems> getAllTranslationServiceAndItemsByIdSection(Long idOfService);
}
