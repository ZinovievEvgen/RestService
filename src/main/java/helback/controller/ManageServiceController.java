package helback.controller;

import helback.dto.SectionDTO;
import helback.dto.ServiceAndItemsDTO;
import helback.service.SectionService;
import helback.service.ServicesAndItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - ServicesAndItems
 */

@Controller
public class ManageServiceController {

    private final ServicesAndItemsService servicesAndItemsService;
    private final SectionService sectionService;

    @Autowired
    public ManageServiceController(ServicesAndItemsService servicesAndItemsService, SectionService sectionService) {
        this.servicesAndItemsService = servicesAndItemsService;
        this.sectionService = sectionService;
    }

    @RequestMapping(value = {"/manage/service"}, method = RequestMethod.GET)
    public String serviceListPage(Model model) {
        model.addAttribute("serviceDTO", new SectionDTO());
        model.addAttribute("serviceDtoList", this.servicesAndItemsService.getAllServicesAndItems());

        return "EditService";
    }

    // delete service
    @RequestMapping(value = "/manage/remove/service/{id}", method = RequestMethod.GET)
    public String removeService(@PathVariable("id") Long id) {
        this.servicesAndItemsService.deleteServicesAndItemsById(id);

        return "redirect:/manage/service";
    }

    // add new service
    @RequestMapping(value = "/manage/add-service", method = RequestMethod.POST)
    public String addService(@ModelAttribute("serviceDTO") ServiceAndItemsDTO servicesAndItemsDTO,
                             @ModelAttribute("section") Long section) {

        this.servicesAndItemsService.addServicesAndItemsWithIdSection(servicesAndItemsDTO, section);
        return "redirect:/manage/service";
    }

    //update service
    @RequestMapping(value = "/manage/update-service", method = RequestMethod.POST)
    public String updateService(@ModelAttribute("serviceDTO") ServiceAndItemsDTO servicesAndItemsDTO, Model model) {
        this.servicesAndItemsService.updateServicesAndItems(servicesAndItemsDTO);

        return "redirect:/manage/service";
    }
}
