package helback.api_manage;

import helback.dto.ServiceAndItemsDTO;
import helback.service.ServicesAndItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса ServicesAndItems
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/service")
@Api(value = "/manage/service", tags = {"Контроллер сущности ServicesAndItems(Сервисы и услуги)"})
public class ServicesAndItemsManageController {


    private final ServicesAndItemsService servicesAndItemsService;

    @Autowired
    public ServicesAndItemsManageController(ServicesAndItemsService servicesAndItemsService) {
        this.servicesAndItemsService = servicesAndItemsService;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести ServicesAndItems по id")
    public ServiceAndItemsDTO getServicesAndItemsById(@PathVariable Long id) {
        return servicesAndItemsService.getServicesAndItemsById(id);
    }

    @PostMapping("/create-another")
    @ApiOperation(value = "Создать ServicesAndItemsDTO with ID")
    public ResponseEntity addServicesAndItemsAnother(@RequestBody ServiceAndItemsDTO servicesAndItemsDTO, @PathVariable Long id) {
        try {
            servicesAndItemsService.addServicesAndItemsWithIdSection(servicesAndItemsDTO, id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать ServicesAndItemsDTO")
    public ResponseEntity addServicesAndItems(@RequestBody ServiceAndItemsDTO servicesAndItemsDTO) {
        try {
            servicesAndItemsService.addServicesAndItemsDTO(servicesAndItemsDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все ServicesAndItems")
    public List<ServiceAndItemsDTO> getAllServicesAndItems() {
        return servicesAndItemsService.getAllServicesAndItems();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить ServicesAndItems по id")
    public void deleteServicesAndItemsById(@PathVariable Long id) {
        servicesAndItemsService.deleteServicesAndItemsById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить ServicesAndItems")
    public void updateServicesAndItems(@RequestBody ServiceAndItemsDTO servicesAndItemsDTO) {
        servicesAndItemsService.updateServicesAndItems(servicesAndItemsDTO);
    }
}
