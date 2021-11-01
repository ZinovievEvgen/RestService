package helback.service_impl;

import helback.dao_abstract.SectionDao;
import helback.dao_abstract.TranslationSectionDao;
import helback.dto.SectionDTO;
import helback.dto.TranslationSectionDTO;
import helback.exception.NotFoundTraslationException;
import helback.mapper.SectionMapper;
import helback.mapper.TranslationSectionMapper;
import helback.models.Section;
import helback.models.TranslationSection;
import helback.service.SectionService;
import helback.service.TranslationSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationSectionServiceImpl implements TranslationSectionService {

    private final TranslationSectionDao translationSectionkDao;
    private final SectionService sectionService;
    private final SectionDao sectionDao;
    private final SectionMapper sectionMapper;
    private final TranslationSectionMapper translationSectionMapper;

    @Autowired
    public TranslationSectionServiceImpl(TranslationSectionDao translationSectionkDao, SectionService sectionService, SectionDao sectionDao, SectionMapper sectionMapper, TranslationSectionMapper translationSectionMapper) {
        this.translationSectionkDao = translationSectionkDao;

        this.sectionService = sectionService;
        this.sectionDao = sectionDao;
        this.sectionMapper = sectionMapper;
        this.translationSectionMapper = translationSectionMapper;
    }


    @Override
    public List<SectionDTO> getTranslationByIdOfSectionAndIdOfLang(String lang) throws NotFoundTraslationException {
        List<Section> listSection = sectionDao.getAll();
        try {
            return translateSection(listSection, lang);
        } catch (NotFoundTraslationException e) {
            throw new NotFoundTraslationException();
        }
    }

    @Override
    public List<SectionDTO> getTranslationByStatusOfSectionAndIdOfLang(String status, String idOfLang) throws NotFoundTraslationException {
        List<Section> listSection = sectionDao.getSectionsByStatus(status);
        try {
            return translateSection(listSection, idOfLang);
        } catch (NotFoundTraslationException e) {
            throw new NotFoundTraslationException();
        }
    }

    @Override
    public List<TranslationSection> getAllTranslationSectionByIdSection(Long idOfSection) {
        return translationSectionkDao.getAllTranslationSectionByIdSection(idOfSection);
    }

    @Override
    public List<TranslationSectionDTO> getAll() {
        return translationSectionMapper.toDto(translationSectionkDao.getAll());
    }

    @Override
    public TranslationSectionDTO getTranslationSectionById(Long id) {
        return translationSectionMapper.toDto(translationSectionkDao.getByKey(id));
    }

    @Override
    public List<TranslationSection> getAllTranslationSection() {
        return translationSectionkDao.getAll();
    }

    @Override
    public void addTranslationSection(TranslationSectionDTO translationSectionDTO) {
        try {
            translationSectionkDao.persist(translationSectionMapper.toEntity(translationSectionDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении сущности");
        }
    }

    @Override
    public void deleteTranslationSectionById(Long id) {
        translationSectionkDao.deleteByKey(id);
    }

    @Override
    public void updateTranslationSection(TranslationSectionDTO translationSectionDTO) {
        try {
            TranslationSection updateTranslationSection = translationSectionkDao.getByKey(translationSectionDTO.getId());
            updateTranslationSection.setSection(sectionService.getSectionById(translationSectionDTO.getSectionId()));
            translationSectionMapper.updateEFromD(translationSectionDTO, updateTranslationSection);
            translationSectionkDao.update(updateTranslationSection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении сущности");
        }
    }

    @Override
    public TranslationSectionDTO getTranslationByIdOfSectionAndIdOfLangSingle(Long idOfService, String idOfLang) throws NotFoundTraslationException {
        return translationSectionMapper.toDto(translationSectionkDao.getTranslationByIdOfSectionAndIdOfLang(idOfService, idOfLang)
                .orElseThrow(NotFoundTraslationException::new));
    }

    @Override
    public SectionDTO getTranslateSectionById(Long idSection, String lang) throws NotFoundTraslationException {
        return singleTranslateSection(idSection, lang);
    }

    private List<SectionDTO> translateSection(List<Section> listSection, String lang) throws NotFoundTraslationException {

        try {
            List<SectionDTO> localeTranslateSection = new ArrayList<>();
            for (int i = 0; i < listSection.size(); i++) {
                SectionDTO currentSectionDTO = sectionMapper.toDto(listSection.get(i));
                TranslationSection currentTranslationSection = translationSectionkDao.getTranslationByIdOfSectionAndIdOfLang(listSection.get(i).getId(), lang).orElseThrow(NotFoundTraslationException::new);
                currentSectionDTO.setDescription(currentTranslationSection.getDescriptionLang());
                localeTranslateSection.add(currentSectionDTO);
            }
            return localeTranslateSection;
        } catch (NotFoundTraslationException n) {
            throw new NotFoundTraslationException();
        }

    }

    private SectionDTO singleTranslateSection(Long id, String lang) throws NotFoundTraslationException {
        try {
            SectionDTO currentSectionDTO = sectionMapper.toDto(sectionDao.getByKey(id));
            TranslationSection currentTranslationSection = translationSectionkDao.getTranslationByIdOfSectionAndIdOfLang(id, lang).orElseThrow(NotFoundTraslationException::new);
            currentSectionDTO.setDescription(currentTranslationSection.getDescriptionLang());
            return currentSectionDTO;
        } catch (
                NotFoundTraslationException n) {
            throw new NotFoundTraslationException();
        }
    }
}
