package helback.service_impl;

import helback.dao_abstract.SectionDao;
import helback.dto.SectionDTO;
import helback.mapper.SectionMapper;
import helback.models.Section;
import helback.service.SectionService;
import helback.utils.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности Section
 */
@Service
public class SectionServiceImpl implements SectionService {

    private final SectionDao sectionDao;
    private final SectionMapper sectionMapper;
    private final CopyService copyService;

    @Autowired
    public SectionServiceImpl(SectionDao sectionDao, SectionMapper sectionMapper, CopyService copyService) {
        this.sectionDao = sectionDao;
        this.sectionMapper = sectionMapper;
        this.copyService = copyService;
    }

    @Override
    public SectionDTO getSectionDTOById(Long id) {
        return sectionMapper.toDto(sectionDao.getByKey(id));
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionDao.getByKey(id);
    }

    @Override
    public void addSection(SectionDTO sectionDTO) {
        sectionDao.persist(sectionMapper.toEntity(sectionDTO));
    }

    @Override
    public List<SectionDTO> getAllSection() {
        return sectionMapper.toDto(sectionDao.getAll());
    }

    @Override
    public void deleteSectionById(Long id) {
        sectionDao.deleteByKey(id);
    }

    @Override
    public void updateSection(SectionDTO sectionDTO) {
        Section updateSection = sectionDao.getByKey(sectionDTO.getId());
        sectionMapper.updateEFromD(sectionDTO, updateSection);

        sectionDao.update(updateSection);
    }

    @Override
    public Section getSectionByName(String description) {
        return sectionDao.getSectionByName(description)
                .orElseThrow(() -> new RuntimeException("Error: Section is not found."));
    }

    @Override
    public List<SectionDTO> getSectionsByStatus(String status) {
        return sectionMapper.toDto(sectionDao.getSectionsByStatus(status));
    }
}
