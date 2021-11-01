package helback.api_manage;

import helback.dto.TranslationSectionDTO;
import helback.service.TranslationSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса  TranslationSection
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/translation-section")
@Api(value = "/manage/translation-section", tags = {"Manage Контроллер сущности TranslationSection"})
public class TranslationSectionManageController {

    private final TranslationSectionService translationSectionService;

    @Autowired
    public TranslationSectionManageController(TranslationSectionService translationSectionService) {
        this.translationSectionService = translationSectionService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все")
    public List<TranslationSectionDTO> getAllTranslationSection() {
        return translationSectionService.getAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести TranslationSection по id")
    public TranslationSectionDTO getTranslationSectionById(@PathVariable Long id) {
        return translationSectionService.getTranslationSectionById(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать TranslationSection")
    public ResponseEntity addTranslationSection(@RequestBody TranslationSectionDTO translationSectionDTO) {
        try {
            translationSectionService.addTranslationSection(translationSectionDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить по id")
    public ResponseEntity deleteTranslationSectionById(@PathVariable Long id) {
        translationSectionService.deleteTranslationSectionById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить")
    public void updateTranslationSection(@RequestBody TranslationSectionDTO translationSectionDTO) {
        translationSectionService.updateTranslationSection(translationSectionDTO);
    }
}
