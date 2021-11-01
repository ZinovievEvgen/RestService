package helback.service;

import helback.dto.SectionDTO;
import helback.models.Section;

import java.util.List;

public interface SectionService {

    SectionDTO getSectionDTOById(Long id);

    Section getSectionById(Long id);

    void addSection(SectionDTO sectionDTO);

    List<SectionDTO> getAllSection();

    void deleteSectionById(Long id);

    void updateSection(SectionDTO sectionDTO);

    Section getSectionByName(String description);

    List<SectionDTO> getSectionsByStatus(String status);

}
