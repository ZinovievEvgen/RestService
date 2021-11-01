package helback.api_manage;


import helback.dto.PersonDTO;
import helback.models.Person;
import helback.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manager) для класса Person
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/person")
@Api(value = "/manage/person", tags = {"Manage Контроллер сущности Person(Пользователь)"})
public class PersonManageController {

    private final PersonService personService;

    @Autowired
    public PersonManageController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести person-ins по id")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести всех person")
    public List<Person> getAllPersons() {
        return personService.getAllPerson();
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

    @PutMapping("/update")
    @ApiOperation(value = "Изменить person")
    public ResponseEntity updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить person по id")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
