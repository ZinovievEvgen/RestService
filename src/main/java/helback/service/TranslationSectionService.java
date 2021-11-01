package helback.service;

import helback.dto.SectionDTO;
import helback.dto.TranslationSectionDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.TranslationSection;

import java.util.List;

public interface TranslationSectionService {

    List<SectionDTO> getTranslationByIdOfSectionAndIdOfLang(String idOfLang) throws NotFoundTraslationException;

    List<SectionDTO> getTranslationByStatusOfSectionAndIdOfLang(String status, String idOfLang) throws NotFoundTraslationException;

    List<TranslationSection> getAllTranslationSectionByIdSection(Long idOfSection);

    List<TranslationSectionDTO> getAll();

    TranslationSectionDTO getTranslationSectionById(Long id);

    List<TranslationSection> getAllTranslationSection();

    void addTranslationSection(TranslationSectionDTO translationSectionDTO);

    void deleteTranslationSectionById(Long id);

    void updateTranslationSection(TranslationSectionDTO translationSectionDTO);

    TranslationSectionDTO getTranslationByIdOfSectionAndIdOfLangSingle(Long idOfService, String idOfLang) throws NotFoundTraslationException;

    SectionDTO getTranslateSectionById(Long idSection, String lang) throws NotFoundTraslationException;
}
