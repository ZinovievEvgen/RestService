package helback.mapper;

import helback.dto.TranslationTaskDTO;
import helback.models.TranslationTask;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TranslationTaskMapper extends EntityMapper<TranslationTaskDTO, TranslationTask> {

    @Override
    @Mapping(source = "taskId", target = "task.id")
    TranslationTask toEntity(TranslationTaskDTO dto);

    @Override
    @Mapping(source = "task.id", target = "taskId")
    TranslationTaskDTO toDto(TranslationTask entity);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "taskId", target = "task.id")
    void updateEFromD(TranslationTaskDTO dto, @MappingTarget TranslationTask entity);
}
