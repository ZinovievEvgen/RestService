package helback.dao_abstract;

import helback.exception.NotFoundTraslationException;
import helback.models.TranslationSection;

import java.util.List;
import java.util.Optional;

public interface TranslationSectionDao extends GenericDao<Long, TranslationSection> {

    Optional<TranslationSection> getTranslationByIdOfSectionAndIdOfLang(Long idOfSection, String idOfLang) throws NotFoundTraslationException;

    List<TranslationSection> getAllTranslationSectionByIdSection(Long idOfSection);

}
