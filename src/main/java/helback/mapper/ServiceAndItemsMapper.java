package helback.mapper;

import helback.dto.ServiceAndItemsDTO;
import helback.models.ServicesAndItems;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceAndItemsMapper extends EntityMapper<ServiceAndItemsDTO, ServicesAndItems> {

    @Override
    @Mapping(source = "sectionId", target = "section.id")
    ServicesAndItems toEntity(ServiceAndItemsDTO dto);

    @Override
    @Mapping(source = "section.id", target = "sectionId")
    ServiceAndItemsDTO toDto(ServicesAndItems entity);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "sectionId", target = "section.id")
    void updateEFromD(ServiceAndItemsDTO dto, @MappingTarget ServicesAndItems entity);
}
