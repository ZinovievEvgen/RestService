package helback.api_manage;


import helback.dto.TaskDTO;
import helback.models.Task;
import helback.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса Task
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/task")
@Api(value = "/manage/task", tags = {"Manage Контроллер сущности Task(Задачи)"})
public class TaskManageController {

    private final TaskService taskService;

    @Autowired
    public TaskManageController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести task по id")
    public Task getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/get-dto/{id}")
    @ApiOperation(value = "Вывести taskDTO по id")
    public TaskDTO getTaskDTOById(@PathVariable long id) {
        return taskService.getTaskByIdWithLang(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все task")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/all-dto")
    @ApiOperation(value = "Вывести все task-dto")
    public List<TaskDTO> getAllDTO() {
        return taskService.getAllDTO();
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать task", consumes = "application/json", produces = "application/json")
    public ResponseEntity createTask(@RequestBody TaskDTO newTaskDTO) {
        try {
            taskService.addTask(newTaskDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить task")
    public ResponseEntity updateTask(@RequestBody TaskDTO taskDTO) {
        taskService.updateTaskDTO(taskDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить task по id")
    public ResponseEntity deleteTask(@PathVariable long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
