package helback.api;

import helback.dto.SectionDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.Section;
import helback.service.SectionService;
import helback.service.TranslationSectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса Section
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/section")
@Api(value = "/section", tags = {"Контроллер сущности Section(Разделы)"})
public class SectionController {

    private final SectionService sectionService;
    private final TranslationSectionService translationSectionService;

    public SectionController(SectionService sectionService, TranslationSectionService translationSectionService) {
        this.sectionService = sectionService;
        this.translationSectionService = translationSectionService;
    }

    @GetMapping("/get-local")
    @ApiOperation(value = "Вывести section по id and locale")
    public SectionDTO getSectionById(@RequestParam(value = "id") Long id,
                                     @RequestParam(value = "lang") String lang) throws NotFoundTraslationException {
        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return sectionService.getSectionDTOById(id);
        } else {
            return translationSectionService.getTranslateSectionById(id, correctLang);
        }
    }

    @GetMapping("/all-locale")
    @ApiOperation(value = "Вывести все section with locale")
    public List<SectionDTO> getAllSectionLocale(@RequestParam(value = "lang") String lang) throws NotFoundTraslationException {
        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return sectionService.getAllSection();
        } else {
            return translationSectionService.getTranslationByIdOfSectionAndIdOfLang(correctLang);
        }
    }

    @GetMapping("/all-status-locale")
    @ApiOperation(value = "Вывести все section with locale")
    public List<SectionDTO> getAllSectionLocaleAndStatus(@RequestParam(value = "lang") String lang, @RequestParam(value = "status") String status) throws NotFoundTraslationException {
        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return sectionService.getSectionsByStatus(status);
        } else {
            return translationSectionService.getTranslationByIdOfSectionAndIdOfLang(correctLang);
        }
    }

    @GetMapping("/get-name")
    @ApiOperation(value = "Вывести section по description")
    public Section getSectionByName(@RequestParam(value = "des") String description) {
        String correctDes = description.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "");
        return sectionService.getSectionByName(correctDes);
    }
}
