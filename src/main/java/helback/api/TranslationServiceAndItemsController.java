package helback.api;


import helback.models.TranslationServiceAndItems;
import helback.service.TranslationServiceAndItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api) для класса  TranslationServiceAndItems
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/translation-items")
@Api(value = "/translation-items", tags = {"Контроллер сущности TranslationServiceAndItems"})
public class TranslationServiceAndItemsController {

    private final TranslationServiceAndItemsService translationServiceAndItemsService;

    public TranslationServiceAndItemsController(TranslationServiceAndItemsService translationServiceAndItemsService) {
        this.translationServiceAndItemsService = translationServiceAndItemsService;
    }

    @GetMapping("/all-service/{id}")
    @ApiOperation(value = "Вывести все по ServiceAndItems")
    public List<TranslationServiceAndItems> getAllTranslationServiceAndItemsByIdService(@PathVariable Long id) {
        return translationServiceAndItemsService.getAllTranslationServiceAndItemsByIdService(id);
    }
}
