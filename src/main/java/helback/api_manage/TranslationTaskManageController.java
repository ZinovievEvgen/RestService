package helback.api_manage;

import helback.dto.TranslationTaskDTO;
import helback.models.TranslationTask;
import helback.service.TranslationTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса  TranslationTask
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/translation-task")
@Api(value = "/manage/translation-task", tags = {"Manage Контроллер сущности TranslationTask"})
public class TranslationTaskManageController {

    private final TranslationTaskService translationTaskService;

    @Autowired
    public TranslationTaskManageController(TranslationTaskService translationTaskService) {
        this.translationTaskService = translationTaskService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все TranslationTask")
    public List<TranslationTask> getAll() {
        return translationTaskService.getAll();
    }

    @GetMapping("/all-dto")
    @ApiOperation(value = "Вывести все TranslationTaskDTO")
    public List<TranslationTaskDTO> getAllDTO() {
        return translationTaskService.getAllDTO();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести translationTask по id")
    public TranslationTask getTranslationTaskById(@PathVariable long id) {
        return translationTaskService.getTranslationTaskById(id);
    }

    @GetMapping("/get-dto/{id}")
    @ApiOperation(value = "Вывести translationTask по id")
    public TranslationTaskDTO getTranslationTaskDTOById(@PathVariable long id) {
        return translationTaskService.getTranslationTaskDTOById(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать translationTask")
    public ResponseEntity addTranslationTask(@RequestBody TranslationTaskDTO translationTaskDTO) {
        try {
            translationTaskService.addTranslationTaskDTO(translationTaskDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить translationTask по id")
    public ResponseEntity deleteTranslationTaskById(@PathVariable Long id) {
        translationTaskService.deleteTranslationTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить translationTask")
    public void updateTranslationTask(@RequestBody TranslationTaskDTO translationTaskDTO) {
        translationTaskService.updateTranslationTask(translationTaskDTO);
    }

}
