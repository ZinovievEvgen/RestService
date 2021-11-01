package helback.api;

import helback.models.TranslationTask;
import helback.service.TranslationTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса  TranslationTask
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/translation")
@Api(value = "/translation-task", tags = {"Контроллер сущности TranslationTask"})
public class TranslationTaskController {

    private final TranslationTaskService translationTaskService;

    @Autowired
    public TranslationTaskController(TranslationTaskService translationTaskService) {
        this.translationTaskService = translationTaskService;
    }


    @GetMapping("/all-by-task/{id}")
    @ApiOperation(value = "Вывести все по task.id")
    public List<TranslationTask> getAllTranslationTaskByIdTask(@PathVariable Long id) {
        return translationTaskService.getAllTranslationTaskByIdTask(id);
    }
}
