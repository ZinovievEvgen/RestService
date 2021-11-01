package helback.controller;

import helback.dto.TranslationServiceAndItemsDTO;
import helback.mapper.ServiceAndItemsMapper;
import helback.models.TranslationServiceAndItems;
import helback.service.ServicesAndItemsService;
import helback.service.TranslationServiceAndItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - TranslationServiceAndItems
 */

@Controller
public class ManageServiceTranslateController {

    private final TranslationServiceAndItemsService translationServiceAndItemsService;
    private final ServicesAndItemsService servicesAndItemsService;
    private final ServiceAndItemsMapper servicesAndItemsMapper;

    @Autowired
    public ManageServiceTranslateController(TranslationServiceAndItemsService translationServiceAndItemsService, ServicesAndItemsService servicesAndItemsService, ServiceAndItemsMapper servicesAndItemsMapper) {
        this.translationServiceAndItemsService = translationServiceAndItemsService;
        this.servicesAndItemsService = servicesAndItemsService;
        this.servicesAndItemsMapper = servicesAndItemsMapper;
    }

    @RequestMapping(value = {"/manage/translate-service"}, method = RequestMethod.GET)
    public String translateServiceListPage(Model model) {
        model.addAttribute("translateService", new TranslationServiceAndItems());
        model.addAttribute("translateServiceList", this.translationServiceAndItemsService.getAll());

        return "EditTrService";
    }

    // delete translate-service
    @RequestMapping(value = "/manage/remove/translate-service/{id}", method = RequestMethod.GET)
    public String removeTranslateService(@PathVariable("id") Long id) {
        this.translationServiceAndItemsService.deleteTranslationServiceAndItemsById(id);

        return "redirect:/manage/translate-service";
    }

    // add new translate-service
    @RequestMapping(value = "/manage/add-translate-service", method = RequestMethod.POST)
    public String addServiceTranslate(@ModelAttribute("translateService") TranslationServiceAndItemsDTO translationServiceAndItemsDTO,
                                      @ModelAttribute("idService") Long idService) {

        translationServiceAndItemsDTO.setServiceId(idService);
        this.translationServiceAndItemsService.addTranslationServiceAndItems(translationServiceAndItemsDTO);

        return "redirect:/manage/translate-service";
    }

    //update translate-service
    @RequestMapping(value = "/manage/update-translate-service", method = RequestMethod.POST)
    public String updateServiceTranslate(@ModelAttribute("translateService") TranslationServiceAndItemsDTO translationServiceAndItemsDTO, Model model) {
        this.translationServiceAndItemsService.updateTranslationServiceAndItems(translationServiceAndItemsDTO);

        return "redirect:/manage/translate-service";
    }
}
