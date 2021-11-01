package helback.service_impl;

import helback.dao_abstract.TaskTypeDao;
import helback.dto.TaskTypeDTO;
import helback.mapper.TaskTypeMapper;
import helback.models.TaskType;
import helback.service.TaskTypeService;
import helback.utils.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности TaskType
 */
@Service
public class TaskTypeServiceImpl implements TaskTypeService {

    private final TaskTypeDao taskTypeDao;
    private final TaskTypeMapper taskTypeMapper;
    private final CopyService copyService;

    @Autowired
    public TaskTypeServiceImpl(TaskTypeDao taskTypeDao, TaskTypeMapper taskTypeMapper, CopyService copyService) {
        this.taskTypeDao = taskTypeDao;
        this.taskTypeMapper = taskTypeMapper;
        this.copyService = copyService;
        ;
    }

    @Override
    public TaskTypeDTO getTaskTypeById(Long id) {
        return taskTypeMapper.toDto(taskTypeDao.getByKey(id));
    }

    @Override
    public void addTaskType(TaskTypeDTO taskTypeDTO) {
        try {
            taskTypeDao.persist(taskTypeMapper.toEntity(taskTypeDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добалвении типа задачи");
        }
    }

    @Override
    public List<TaskTypeDTO> getAllTaskType() {
        return taskTypeMapper.toDto(taskTypeDao.getAll());
    }

    @Override
    public void deleteTaskTypeById(Long id) {
        try {
            taskTypeDao.deleteByKey(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при удалении типа задачи");
        }
    }

    @Override
    public void updateTaskType(TaskTypeDTO taskTypeDTO) {
        try {
            TaskType updateTaskType = taskTypeDao.getByKey(taskTypeDTO.getId());
            taskTypeMapper.updateEFromD(taskTypeDTO, updateTaskType);
            taskTypeDao.update(updateTaskType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении типа задачи");
        }
    }
}
