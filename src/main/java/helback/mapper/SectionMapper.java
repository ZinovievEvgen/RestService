package helback.mapper;

import helback.dto.SectionDTO;
import helback.models.Section;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SectionMapper extends EntityMapper<SectionDTO, Section> {

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    void updateEFromD(SectionDTO dto, @MappingTarget Section entity);
}
