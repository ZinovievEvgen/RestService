package helback.api_manage;

import helback.dto.TaskTypeDTO;
import helback.service.TaskTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса TaskType
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/taskType")
@Api(value = "/manage/taskType", tags = {"Manage Контроллер сущности TaskType(Тип задачи)"})
public class TaskTypeManageController {

    private final TaskTypeService taskTypeService;

    @Autowired
    public TaskTypeManageController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести taskType по id")
    public TaskTypeDTO getTaskTypeById(@PathVariable long id) {
        return taskTypeService.getTaskTypeById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все taskType")
    public List<TaskTypeDTO> getAllTaskTypes() {
        return taskTypeService.getAllTaskType();
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать taskType")
    public ResponseEntity createTaskType(@RequestBody TaskTypeDTO taskTypeDTO) {
        taskTypeService.addTaskType(taskTypeDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить taskType")
    public ResponseEntity updateTaskType(@RequestBody TaskTypeDTO taskTypeDTO) {
        taskTypeService.updateTaskType(taskTypeDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить taskType по id")
    public ResponseEntity deleteTaskType(@PathVariable long id) {
        taskTypeService.deleteTaskTypeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
