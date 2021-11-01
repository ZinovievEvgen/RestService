package helback.service;


import helback.dto.TaskTypeDTO;

import java.util.List;

/**
 * Слой бизнес логики (Service)
 * интерфейс service для сущности TaskType
 */
public interface TaskTypeService {

    TaskTypeDTO getTaskTypeById(Long id);

    void addTaskType(TaskTypeDTO taskTypeDTO);

    List<TaskTypeDTO> getAllTaskType();

    void deleteTaskTypeById(Long id);

    void updateTaskType(TaskTypeDTO taskTypeDTO);
}
