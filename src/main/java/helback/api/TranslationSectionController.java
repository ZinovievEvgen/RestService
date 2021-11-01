package helback.api;

import helback.dto.TranslationSectionDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.TranslationSection;
import helback.service.TranslationSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса  TranslationSection
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/translation-section")
@Api(value = "/translation-section", tags = {"Контроллер сущности TranslationSection"})
public class TranslationSectionController {

    private final TranslationSectionService translationSectionService;

    public TranslationSectionController(TranslationSectionService translationSectionService) {
        this.translationSectionService = translationSectionService;
    }

    @GetMapping("/get-single")
    @ApiOperation(value = "Вывести одну запись по lang и service")
    public TranslationSectionDTO getTranslationByIdOfSectionAndIdOfLangSingle(@RequestParam(value = "section") Long idOfSection,
                                                                              @RequestParam(value = "lang") String idOfLang) throws NotFoundTraslationException {
        String correctLang = idOfLang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return translationSectionService.getTranslationSectionById(idOfSection);
        } else {
            return translationSectionService.getTranslationByIdOfSectionAndIdOfLangSingle(idOfSection, correctLang);
        }
    }

    @GetMapping("/all-section/{id}")
    @ApiOperation(value = "Вывести все по section")
    public List<TranslationSection> getAllTranslationSectionByIdSection(@PathVariable Long id) {
        return translationSectionService.getAllTranslationSectionByIdSection(id);
    }
}
