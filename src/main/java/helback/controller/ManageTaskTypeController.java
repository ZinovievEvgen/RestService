package helback.controller;

import helback.dto.TaskTypeDTO;
import helback.models.TaskType;
import helback.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - TaskType
 */

@Controller
public class ManageTaskTypeController {


    private final TaskTypeService taskTypeService;

    @Autowired
    public ManageTaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @RequestMapping(value = {"/manage/task-types"}, method = RequestMethod.GET)
    public String taskTypeListPage(Model model) {
        model.addAttribute("taskType", new TaskType());
        model.addAttribute("taskTypeList", this.taskTypeService.getAllTaskType());

        return "EditTaskType";
    }

    // delete taskType
    @RequestMapping(value = "/manage/remove/task-type/{id}", method = RequestMethod.GET)
    public String removeTaskType(@PathVariable("id") Long id) {
        this.taskTypeService.deleteTaskTypeById(id);

        return "redirect:/manage/task-types";
    }

    // add new taskType
    @RequestMapping(value = "/manage/add-task-type", method = RequestMethod.POST)
    public String addTaskType(@ModelAttribute("taskTypeDTO") TaskTypeDTO taskTypeDTO) {

        this.taskTypeService.addTaskType(taskTypeDTO);

        return "redirect:/manage/task-types";
    }

    //update taskType
    @RequestMapping(value = "/manage/update-task-type", method = RequestMethod.POST)
    public String updateTaskType(@ModelAttribute("taskTypeDTO") TaskTypeDTO taskTypeDTO, Model model) {
        this.taskTypeService.updateTaskType(taskTypeDTO);

        return "redirect:/manage/task-types";
    }
}
