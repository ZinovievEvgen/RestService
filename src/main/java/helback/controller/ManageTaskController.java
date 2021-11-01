package helback.controller;

import helback.dto.TaskDTO;
import helback.mapper.TaskMapper;
import helback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - Task
 */

@Controller
public class ManageTaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @Autowired
    public ManageTaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }


    @RequestMapping(value = {"/manage/tasks"}, method = RequestMethod.GET)
    public String taskListPage(Model model) {
        model.addAttribute("taskDTO", new TaskDTO());
        model.addAttribute("taskDtoList", this.taskService.getAllDTO());

        return "EditTask";
    }

    // delete task
    @RequestMapping(value = "/manage/remove/task/{id}", method = RequestMethod.GET)
    public String removeTask(@PathVariable("id") Long id) {
        this.taskService.deleteTaskById(id);

        return "redirect:/manage/tasks";
    }

    // add new task
    @RequestMapping(value = "/manage/add-task", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("taskDTO") TaskDTO taskDTO,
                          @ModelAttribute("types") Long idType) {

        taskDTO.setQuantitySuccess((int) (Math.random() * 10));

        if (idType == 1L) {
            taskDTO.setTimeToLive(3L);
        } else if (idType == 5L) {
            taskDTO.setTimeToLive(12L);
        } else if (idType == 2L) {
            taskDTO.setTimeToLive(7L);
        } else {
            taskDTO.setTimeToLive(99L);
        }
        this.taskService.addTask(taskDTO);

        return "redirect:/manage/tasks";
    }

    //update task
    @RequestMapping(value = "/manage/update-task", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute("taskDTO") TaskDTO taskDTO, Model model) {
        this.taskService.updateTaskDTO(taskDTO);

        return "redirect:/manage/tasks";
    }
}
