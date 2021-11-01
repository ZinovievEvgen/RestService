package helback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * необходимы для отображения начальной страницы управления и страницы авторизации
 */


@Controller
public class ManageTitleController {
    @RequestMapping(value = {"/panel-title"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "index";
    }

    //manage panel
    @RequestMapping(value = {"/manage"}, method = RequestMethod.GET)
    public String managePage(Model model) {
        return "manage";
    }
}
