package helback.controller;

import helback.dto.TranslationTaskDTO;
import helback.models.TranslationTask;
import helback.service.TaskService;
import helback.service.TranslationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - TranslateTask
 */

@Controller
public class ManageTranslateTaskController {

    private final TranslationTaskService translationTaskService;
    private final TaskService taskService;

    @Autowired
    public ManageTranslateTaskController(TranslationTaskService translationTaskService, TaskService taskService) {
        this.translationTaskService = translationTaskService;
        this.taskService = taskService;
    }


    @RequestMapping(value = {"/manage/translate-task"}, method = RequestMethod.GET)
    public String translateTaskListPage(Model model) {
        model.addAttribute("translateTask", new TranslationTask());
        model.addAttribute("translateTaskList", this.translationTaskService.getAll());

        return "EditTrTask";
    }

    // delete translate-task
    @RequestMapping(value = "/manage/remove/translate-task/{id}", method = RequestMethod.GET)
    public String removeTranslateTask(@PathVariable("id") Long id) {
        this.translationTaskService.deleteTranslationTaskById(id);

        return "redirect:/manage/translate-task";
    }

    // add new translate-task
    @RequestMapping(value = "/manage/add-translate-task", method = RequestMethod.POST)
    public String addTranslateTask(@ModelAttribute("translateTask") TranslationTaskDTO translationTaskDTO,
                                   @ModelAttribute("idTask") Long idTask) {

        translationTaskDTO.setTaskId(idTask);
        this.translationTaskService.addTranslationTaskDTO(translationTaskDTO);

        return "redirect:/manage/translate-task";
    }

    //update translate-task
    @RequestMapping(value = "/manage/update-translate-task", method = RequestMethod.POST)
    public String updateTranslateTask(@ModelAttribute("translateTask") TranslationTaskDTO translationTaskDTO, Model model) {
        this.translationTaskService.updateTranslationTask(translationTaskDTO);

        return "redirect:/manage/translate-task";
    }
}
