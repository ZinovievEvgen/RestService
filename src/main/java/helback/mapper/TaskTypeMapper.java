package helback.mapper;

import helback.dto.TaskTypeDTO;
import helback.models.TaskType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskTypeMapper extends EntityMapper<TaskTypeDTO, TaskType> {

    TaskTypeMapper INSTANCE = Mappers.getMapper(TaskTypeMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    void updateEFromD(TaskTypeDTO dto, @MappingTarget TaskType entity);
}