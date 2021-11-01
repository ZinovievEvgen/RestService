package helback.api;

import helback.dto.TaskDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.Task;
import helback.service.TaskService;
import helback.service.TranslationTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса Task
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/task")
@Api(value = "/task", tags = {"Контроллер сущности Task(Задачи)"})
public class TaskController {

    private final TaskService taskService;
    private final TranslationTaskService translationTaskService;

    @Autowired
    public TaskController(TaskService taskService, TranslationTaskService translationTaskService) {

        this.taskService = taskService;
        this.translationTaskService = translationTaskService;
    }

    @GetMapping("/get-simple/{id}")
    @ApiOperation(value = "Вывести task по id")
    public Task getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Вывести task по id с локализацией")
    public TaskDTO getTaskByIdWithLang(@RequestParam(value = "id") Long id,
                                       @RequestParam(value = "lang") String lang) throws NotFoundTraslationException {

        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return taskService.getTaskByIdWithLang(id);
        } else {
            try {
                return translationTaskService.getTaskByIdWithLang(id, lang);
            } catch (NotFoundTraslationException e) {
                throw new NotFoundTraslationException();
            }
        }
    }

    @GetMapping("/preview")
    @ApiOperation(value = "Вывести все task")
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

    @GetMapping("/get-by-type/{id}")
    @ApiOperation(value = "Вывести все task по типу")
    public List<Task> getTaskByType(@PathVariable long id) {
        return taskService.getTaskByType(id);
    }
}
