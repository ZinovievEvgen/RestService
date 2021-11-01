package helback.api;

import helback.service.CompleteListTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST API (api) для класса CompleteListTask
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/complete-list")
@Api(value = "/complete-list", tags = {"Контроллер сущности CompleteListTask(учет вып. заданий)"})
public class CompleteListTaskController {

    private final CompleteListTaskService completeListTaskService;

    @Autowired
    public CompleteListTaskController(CompleteListTaskService completeListTaskService) {
        this.completeListTaskService = completeListTaskService;
    }

    @GetMapping("/add-create-time")
    @ApiOperation(value = "Добавить время начала выполнения задачи")
    public ResponseEntity addCreateTimeTask(@RequestParam(value = "uniqueId") String uniqueId,
                                            @RequestParam(value = "idOfTask") Long idOfTask) {

        String correctUn = uniqueId.replaceAll("[^a-zA-Z0-9-]", "");
        completeListTaskService.addCreateTimeTask(correctUn, idOfTask);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/add-complete-time")
    @ApiOperation(value = "Добавить время окончания выполнения задачи")
    public ResponseEntity addCompleteTimeTask(@RequestParam(value = "uniqueId") String uniqueId,
                                              @RequestParam(value = "idOfTask") Long idOfTask) throws Exception {
        String correctUn = uniqueId.replaceAll("[^a-zA-Z0-9-]", "");
        completeListTaskService.addCompleteTimeTask(correctUn, idOfTask);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
