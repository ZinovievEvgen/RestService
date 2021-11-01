package helback.service;


import helback.dto.TaskDTO;
import helback.models.Task;

import java.util.List;

/**
 * Слой бизнес логики (Service)
 * интерфейс service для сущности Task
 */
public interface TaskService {

    Task getTaskById(Long id);

    TaskDTO getTaskByIdWithLang(Long id);

    void addTask(TaskDTO taskDTO);

    void deleteTaskById(Long id);

    void updateTaskDTO(TaskDTO taskDTO);

    void updateTask(Task task);

    List<TaskDTO> getAllDTO();

    List<Task> getAll();

    List<Task> getTaskByType(Long id);
}
