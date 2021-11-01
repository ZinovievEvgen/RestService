package helback.api_manage;

import helback.dto.TranslationServiceAndItemsDTO;
import helback.service.TranslationServiceAndItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса  TranslationServiceAndItems
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/translation-items")
@Api(value = "/manage/translation-items", tags = {"Manage Контроллер сущности TranslationServiceAndItems"})
public class TranslationServiceAndItemsManageController {

    private final TranslationServiceAndItemsService translationServiceAndItemsService;

    @Autowired
    public TranslationServiceAndItemsManageController(TranslationServiceAndItemsService translationServiceAndItemsService) {
        this.translationServiceAndItemsService = translationServiceAndItemsService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все")
    public List<TranslationServiceAndItemsDTO> getAll() {
        return translationServiceAndItemsService.getAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести TranslationServiceAndItems по id")
    public TranslationServiceAndItemsDTO getTranslationServiceAndItemsById(@PathVariable Long id) {
        return translationServiceAndItemsService.getTranslationServiceAndItemsById(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать")
    public ResponseEntity addTranslationServiceAndItems(@RequestBody TranslationServiceAndItemsDTO translationServiceAndItemsDTO) {
        try {
            translationServiceAndItemsService.addTranslationServiceAndItems(translationServiceAndItemsDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить по id")
    public ResponseEntity deleteTranslationServiceAndItemsById(@PathVariable Long id) {
        translationServiceAndItemsService.deleteTranslationServiceAndItemsById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить")
    public void updateTranslationServiceAndItems(@RequestBody TranslationServiceAndItemsDTO translationServiceAndItemsDTO) {
        translationServiceAndItemsService.updateTranslationServiceAndItems(translationServiceAndItemsDTO);
    }
}
