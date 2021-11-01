package helback.api;

import helback.dto.ServiceAndItemsDTO;
import helback.exception.NotFoundTraslationException;
import helback.models.ServicesAndItems;
import helback.service.ServicesAndItemsService;
import helback.service.TranslationServiceAndItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса ServicesAndItems
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/service")
@Api(value = "/service", tags = {"Контроллер сущности ServicesAndItems(Сервисы и услуги)"})
public class ServicesAndItemsController {

    private final ServicesAndItemsService servicesAndItemsService;
    private final TranslationServiceAndItemsService translationServiceAndItemsService;

    public ServicesAndItemsController(ServicesAndItemsService servicesAndItemsService, TranslationServiceAndItemsService translationServiceAndItemsService) {
        this.servicesAndItemsService = servicesAndItemsService;
        this.translationServiceAndItemsService = translationServiceAndItemsService;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести ServicesAndItems по id")
    public ServiceAndItemsDTO getServicesAndItemsById(@PathVariable Long id) {
        return servicesAndItemsService.getServicesAndItemsById(id);
    }

    @GetMapping("/get-local")
    @ApiOperation(value = "Вывести section по id and locale")
    public ServiceAndItemsDTO getSectionById(@RequestParam(value = "id") Long id,
                                              @RequestParam(value = "lang") String lang) throws NotFoundTraslationException {
        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return servicesAndItemsService.getServicesAndItemsById(id);
        } else {
            return translationServiceAndItemsService.getTranslateTranslationServiceAndItemsById(id, correctLang);
        }
    }

    @GetMapping("/all-locale")
    @ApiOperation(value = "Вывести все section with locale")
    public List<ServiceAndItemsDTO> getAllSectionLocale(@RequestParam(value = "id") Long id,
                                                         @RequestParam(value = "lang") String lang) throws NotFoundTraslationException {
        String correctLang = lang.replaceAll("[^a-zA-Z]", "");
        if (correctLang == null || correctLang.equals("ru")) {
            return servicesAndItemsService.getServicesAndItemsBySection(id);
        } else {
            return translationServiceAndItemsService.getTranslationByIdOfServiceAndIdOfLang(id, correctLang);
        }
    }

    @GetMapping("/get-by-location")
    @ApiOperation(value = "Вывести section по description")
    public List<ServicesAndItems> getServicesAndItemsByLocation(@RequestParam(value = "location") String location) {
        String correctLoc = location.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "");
        return servicesAndItemsService.getServicesAndItemsByLocation(correctLoc);
    }

    @GetMapping("/get-by-section")
    @ApiOperation(value = "Вывести section по section name")
    public List<ServiceAndItemsDTO> getServicesAndItemsBySection(@RequestParam(value = "id") Long id) {
        return servicesAndItemsService.getServicesAndItemsBySection(id);
    }
}
