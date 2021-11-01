package helback.mapper;

import helback.dto.TranslationServiceAndItemsDTO;
import helback.models.TranslationServiceAndItems;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TranslationServiceAndItemsMapper extends EntityMapper<TranslationServiceAndItemsDTO, TranslationServiceAndItems> {

    @Override
    @Mapping(source = "serviceId", target = "servicesAndItems.id")
    TranslationServiceAndItems toEntity(TranslationServiceAndItemsDTO dto);

    @Override
    @Mapping(source = "servicesAndItems.id", target = "serviceId")
    TranslationServiceAndItemsDTO toDto(TranslationServiceAndItems entity);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "serviceId", target = "servicesAndItems.id")
    void updateEFromD(TranslationServiceAndItemsDTO dto, @MappingTarget TranslationServiceAndItems entity);
}
