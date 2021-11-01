package helback.api_manage;

import helback.models.CompleteListTask;
import helback.service.CompleteListTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса CompleteListTask
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/complete-list")
@Api(value = "/manage/complete-list", tags = {"Manage Контроллер сущности CompleteListTask(учет вып. заданий)"})
public class CompleteListTaskManageController {

    private final CompleteListTaskService completeListTaskService;

    @Autowired
    public CompleteListTaskManageController(CompleteListTaskService completeListTaskService) {
        this.completeListTaskService = completeListTaskService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все вып. задания")
    public List<CompleteListTask> getCompleteListTask() {
        return completeListTaskService.getAllCompleteListTask();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести CompleteListTask по id")
    public CompleteListTask getCompleteListTaskById(@PathVariable long id) {
        return completeListTaskService.getCompleteListTaskById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить CompleteListTask")
    public ResponseEntity updateCompleteListTask(@RequestBody CompleteListTask completeListTask) {
        completeListTaskService.updateCompleteListTask(completeListTask);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить CompleteListTask по id")
    public ResponseEntity deleteCompleteListTask(@PathVariable long id) {
        completeListTaskService.deleteCompleteListTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
