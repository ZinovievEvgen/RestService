package helback.controller;


import helback.models.Person;
import helback.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * * Слой контроллеров управления данными (ManageController)
 * реализует CRUD операции для сущности - Person
 */

@Controller
public class ManagePersonController {

    private final PersonService personService;

    @Autowired
    public ManagePersonController(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping(value = {"/manage/person"}, method = RequestMethod.GET)
    public String personListPage(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("personList", this.personService.getAllPerson());

        return "EditPerson";
    }

    // delete task
    @RequestMapping(value = "/manage/remove/person/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") Long id) {
        this.personService.deletePersonById(id);

        return "redirect:/manage/person";
    }

    //update task
    @RequestMapping(value = "/manage/update-person", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") Person person, Model model) {
        this.personService.updatePerson(person);

        return "redirect:/manage/person";
    }
}
