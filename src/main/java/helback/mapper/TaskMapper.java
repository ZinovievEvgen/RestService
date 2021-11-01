package helback.mapper;

import helback.dto.TaskDTO;
import helback.models.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {

    @Override
    @Mapping(source = "taskTypeId", target = "taskType.id")
    Task toEntity(TaskDTO dto);

    @Override
    @Mapping(source = "taskType.id", target = "taskTypeId")
    TaskDTO toDto(Task entity);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "taskTypeId", target = "taskType.id")
    void updateEFromD(TaskDTO dto, @MappingTarget Task entity);
}