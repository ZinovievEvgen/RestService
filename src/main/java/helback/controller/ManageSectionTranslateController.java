package helback.controller;

import helback.dto.TranslationSectionDTO;
import helback.models.TranslationSection;
import helback.service.SectionService;
import helback.service.TranslationSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - TranslateSection
 */

@Controller
public class ManageSectionTranslateController {

    private final TranslationSectionService translationSectionService;
    private final SectionService sectionService;

    @Autowired
    public ManageSectionTranslateController(TranslationSectionService translationSectionService, SectionService sectionService) {
        this.translationSectionService = translationSectionService;
        this.sectionService = sectionService;
    }

    @RequestMapping(value = {"/manage/translate-section"}, method = RequestMethod.GET)
    public String translateSectionListPage(Model model) {
        model.addAttribute("translationSection", new TranslationSection());
        model.addAttribute("translationSectionList", this.translationSectionService.getAllTranslationSection());

        return "EditTrSection";
    }

    // delete translate-section
    @RequestMapping(value = "/manage/remove/translate-section/{id}", method = RequestMethod.GET)
    public String removeTranslationSection(@PathVariable("id") Long id) {
        this.translationSectionService.deleteTranslationSectionById(id);

        return "redirect:/manage/translate-section";
    }

    // add new translate-section
    @RequestMapping(value = "/manage/add-translate-section", method = RequestMethod.POST)
    public String addTranslationSection(@ModelAttribute("translateService") TranslationSectionDTO translationSectionDTO,
                                        @ModelAttribute("idSection") Long idSection) {

        translationSectionDTO.setSectionId(idSection);
        this.translationSectionService.addTranslationSection(translationSectionDTO);

        return "redirect:/manage/translate-section";
    }

    //update translate-section
    @RequestMapping(value = "/manage/update-translate-section", method = RequestMethod.POST)
    public String updateTranslationSection(@ModelAttribute("translateService") TranslationSectionDTO translationSectionDTO, Model model) {
        this.translationSectionService.updateTranslationSection(translationSectionDTO);

        return "redirect:/manage/translate-section";
    }
}
