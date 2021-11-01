package helback.api;

import helback.dto.PersonDTO;
import helback.dto.TaskDTO;
import helback.exception.NotFoundTraslationException;
import helback.exception.PersonNotFoundException;
import helback.models.Person;
import helback.service.PersonService;
import helback.service.TranslationTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса Person
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/person")
@Api(value = "/person", tags = {"Контроллер сущности Person(Пользователь)"})
public class PersonController {

    private final PersonService personService;
    private final TranslationTaskService translationTaskService;

    @Autowired
    public PersonController(PersonService personService, TranslationTaskService translationTaskService) {
        this.personService = personService;
        this.translationTaskService = translationTaskService;
    }

    @GetMapping("/get-dto/{id}")
    @ApiOperation(value = "Вывести person-ins по id")
    public PersonDTO getPersonDTOById(@PathVariable Long id) {
        return personService.getPersonDTOById(id);
    }

    @GetMapping("/another-get")
    @ApiOperation(value = "Вывести person-ins по uniqueId")
    public Person getPersonByUniqueId(@RequestParam(value = "un") String uniqueId) {

        String correctUn = uniqueId.replaceAll("[^a-zA-Z0-9-]", "");
        return personService.getPersonByUniqueId(correctUn);
    }

    @GetMapping("/complete-list-task")
    @ApiOperation(value = "Вывести выполненные задачи у  person")
    public List<TaskDTO> getAllCompleteTaskByPerson(@RequestParam(value = "un") String uniqueId,
                                                    @RequestParam(value = "lang") String lang) throws NotFoundTraslationException {
        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return personService.completeTaskByPerson(uniqueId);
        } else {
            return translationTaskService.getTranslationCompleteTaskByLangAndTaskForUnPerson(uniqueId, correctLang);
        }
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Создать person")
    public ResponseEntity createPerson(@RequestBody PersonDTO personDTO) {
        try {
            // возврат конкретного - созданного пользователя
            personService.addPerson(personDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-allow-task-list")
    @ApiOperation(value = "Вывести все доступные таски у person по id")
    public List<TaskDTO> getAllowTaskList(@RequestParam(value = "id") Long id,
                                          @RequestParam(value = "lang") String lang) throws NotFoundTraslationException, PersonNotFoundException {

        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return personService.getAllowTaskList(id, correctLang);
        } else {
            return translationTaskService.getTranslationTaskByLangAndTaskForPerson(id, correctLang);
        }
    }

    @GetMapping("/get-un-allow-task-list")
    @ApiOperation(value = "Вывести все доступные таски у person по uniqueId")
    public List<TaskDTO> getAllowTaskListAnother(@RequestParam(value = "un") String uniqueId,
                                                 @RequestParam(value = "lang") String lang) throws NotFoundTraslationException, PersonNotFoundException {

        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return personService.getAllowTaskListAnother(uniqueId, correctLang);
        } else {
            return translationTaskService.getTranslationTaskByLangAndTaskForUnPerson(uniqueId, correctLang);
        }

    }

    @GetMapping("/get-friend")
    @ApiOperation(value = "Вывести друзей у person по uniqueId")
    public List<PersonDTO> getAllowTaskListAnother(@RequestParam(value = "un") String uniqueId) {
        String correctUn = uniqueId.replaceAll("[^a-zA-Z0-9-]", "");
        return personService.getFriends(correctUn);
    }
}