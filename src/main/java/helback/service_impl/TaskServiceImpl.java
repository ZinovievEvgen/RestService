package helback.service_impl;

import helback.dao_abstract.TaskDao;
import helback.dao_abstract.TaskTypeDao;
import helback.dto.TaskDTO;
import helback.mapper.TaskMapper;
import helback.models.Task;
import helback.service.HistoryAnalyseTaskService;
import helback.service.TaskService;
import helback.utils.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности Task
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;
    private final TaskMapper taskMapper;
    private final TaskTypeDao taskTypeDao;
    private final HistoryAnalyseTaskService historyAnalyseTaskService;
    private final CopyService copyService;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao, TaskMapper taskMapper, TaskTypeDao taskTypeDao, HistoryAnalyseTaskService historyAnalyseTaskService, CopyService copyService) {
        this.taskDao = taskDao;
        this.taskMapper = taskMapper;
        this.taskTypeDao = taskTypeDao;
        this.historyAnalyseTaskService = historyAnalyseTaskService;
        this.copyService = copyService;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getByKey(id);
    }

    @Override
    public TaskDTO getTaskByIdWithLang(Long id) {
        return taskMapper.toDto(taskDao.getByKey(id));
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        try {
            Task task = taskMapper.toEntity(taskDTO);
            taskDao.persist(task);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении задачи");
        }
    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            taskDao.deleteByKey(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при удалении задачи");
        }
    }

    @Override
    public void updateTaskDTO(TaskDTO taskDTO) {
        try {
            Task updateTask = taskDao.getByKey(taskDTO.getId());
            updateTask.setTaskType(taskTypeDao.getByKey(taskDTO.getTaskTypeId()));
            taskMapper.updateEFromD(taskDTO, updateTask);
            taskDao.update(updateTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении задачи");
        }
    }

    @Override
    public void updateTask(Task task) {
        try {
            taskDao.update(task);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении задачи");
        }
    }

    @Override
    public List<TaskDTO> getAllDTO() {
        return taskMapper.toDto(taskDao.getAll());
    }

    @Override
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    public List<Task> getTaskByType(Long id) {
        return taskDao.getTaskByType(id);
    }

    protected void fixOrderedTask(Long ordered) {

    }
}
