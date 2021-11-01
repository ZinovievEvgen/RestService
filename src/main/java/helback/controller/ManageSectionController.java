package helback.controller;

import helback.dto.SectionDTO;
import helback.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - Section
 */

@Controller
public class ManageSectionController {

    private final SectionService sectionService;

    @Autowired
    public ManageSectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(value = {"/manage/sections"}, method = RequestMethod.GET)
    public String sectionListPage(Model model) {
        model.addAttribute("sectionDTO", new SectionDTO());
        model.addAttribute("sectionDtoList", this.sectionService.getAllSection());

        return "EditSection";
    }

    // delete section
    @RequestMapping(value = "/manage/remove/section/{id}", method = RequestMethod.GET)
    public String removeSection(@PathVariable("id") Long id) {
        this.sectionService.deleteSectionById(id);

        return "redirect:/manage/sections";
    }

    // add new section
    @RequestMapping(value = "/manage/add-section", method = RequestMethod.POST)
    public String addSection(@ModelAttribute("sectionDTO") SectionDTO sectionDTO) {

        this.sectionService.addSection(sectionDTO);

        return "redirect:/manage/sections";
    }

    //update section
    @RequestMapping(value = "/manage/update-section", method = RequestMethod.POST)
    public String updateSection(@ModelAttribute("sectionDTO") SectionDTO sectionDTO, Model model) {
        this.sectionService.updateSection(sectionDTO);

        return "redirect:/manage/sections";
    }
}
