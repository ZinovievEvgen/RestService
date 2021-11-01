package helback.mapper;

import helback.dto.TranslationSectionDTO;
import helback.models.TranslationSection;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TranslationSectionMapper extends EntityMapper<TranslationSectionDTO, TranslationSection> {

    @Override
    @Mapping(source = "sectionId", target = "section.id")
    TranslationSection toEntity(TranslationSectionDTO dto);

    @Override
    @Mapping(source = "section.id", target = "sectionId")
    TranslationSectionDTO toDto(TranslationSection entity);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "sectionId", target = "section.id")
    void updateEFromD(TranslationSectionDTO dto, @MappingTarget TranslationSection entity);
}
