package helback.schedule_service_impl;

import helback.models.Person;
import helback.models.Task;
import helback.schedule_service.TaskScheduleService;
import helback.service.CompleteListTaskService;
import helback.service.HistoryAnalyseTaskService;
import helback.service.PersonService;
import helback.service.TaskService;
import helback.service_impl.DataFormatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Слой бизнес логики (Service)
 * класс реализация ScheduleService для сущности Task
 */
@Service
public class YearTaskServiceImpl implements TaskScheduleService {

    @Value("${PATH_FROM_FILE_YEA}")
    private String fromFileYear;

    private final TaskService taskService;
    private final PersonService personService;
    private final DataFormatterService dataFormatterService;
    private final CompleteListTaskService completeListTaskService;
    private final HistoryAnalyseTaskService historyAnalyseTaskService;

    @Autowired
    public YearTaskServiceImpl(TaskService taskService, PersonService personService, DataFormatterService dataFormatterService, CompleteListTaskService completeListTaskService, HistoryAnalyseTaskService historyAnalyseTaskService) {
        this.taskService = taskService;
        this.personService = personService;
        this.dataFormatterService = dataFormatterService;
        this.completeListTaskService = completeListTaskService;
        this.historyAnalyseTaskService = historyAnalyseTaskService;
    }


    /**
     * порядок обновления:
     * 1. проверяем список доступных задач (ттл = 12), если не пустой - редактируем ХП - очищаем
     * 2. проверяем список выполненных задач (ттл = 12), если не пустой - очищаем
     * 3. проверяем начатые задачи, если есть - очищаем
     * 4. считываем из файла ид задач и добавляем в имеющийся список к годовым и т.д, обновляем данные по количеству выполнений
     */


    @Override
    public void refreshAllowTaskList() {
        List<Task> notCompleteTaskList = new ArrayList<>();
        List<Person> personList = personService.getAllPerson();

        for (int a = 0; a < personList.size(); a++) {
            for (int b = 0; b < personList.get(a).getAllowTaskList().size(); b++) {
                if (personList.get(a).getAllowTaskList().get(b).getTimeToLive() == 12L) {
                    notCompleteTaskList.add(personList.get(a).getAllowTaskList().get(b));
                }
            }

            if (!notCompleteTaskList.isEmpty()) {
                personService.updateHealtyPointByPerson(personList.get(a), notCompleteTaskList);
                for (int c = 0; c < notCompleteTaskList.size(); c++) {
                    personService.deleteTaskOnAllowTaskList(personList.get(a), notCompleteTaskList.get(c));
                }
                notCompleteTaskList.clear();
            }
        }
    }

    @Override
    public void refreshCompleteTaskList() {
        List<Task> completeTaskListByPerson;
        List<Task> completeYearTaskList = new ArrayList<>();
        List<Person> personList = personService.getAllPerson();

        for (int d = 0; d < personList.size(); d++) {
            completeTaskListByPerson = completeListTaskService.getAllCompleteTaskByPerson(personList.get(d).getId());

            for (int e = 0; e < completeTaskListByPerson.size(); e++) {
                if (completeTaskListByPerson.get(e).getTimeToLive() == 12L) {
                    completeYearTaskList.add(completeTaskListByPerson.get(e));
                }
            }

            System.out.println("В списке completeDailyTaskList занесены следующие ежегодные таски:");
            for (Task task : completeYearTaskList) {
                System.out.println(task.getId());
            }

            if (!completeYearTaskList.isEmpty()) {
                for (int f = 0; f < completeYearTaskList.size(); f++) {
                    personService.clearCompleteTaskList(personList.get(d), completeYearTaskList.get(f));
                }
                completeYearTaskList.clear();
            }
        }
    }

    @Override
    public void closeStartedTask() {
        List<Task> notCompleteYearTaskList;
        List<Person> personList = personService.getAllPerson();

        for (int i = 0; i < personList.size(); i++) {
            notCompleteYearTaskList = completeListTaskService.getAllOpenCompleteTaskByPerson(personList.get(i).getId(),
                    LocalDate.now().minusYears(1).atTime(0, 0, 0),
                    LocalDate.now().atTime(23, 59, 59));

            if (!notCompleteYearTaskList.isEmpty()) {
                for (int j = 0; j < notCompleteYearTaskList.size(); j++) {
                    completeListTaskService.deleteByPersonAndTask(personList.get(i), notCompleteYearTaskList.get(j));
                }
                notCompleteYearTaskList.clear();
            }
        }
    }

    @Override
    public void addNewTasks() {
        List<Person> personList = personService.getAllPerson();
        List<Task> newTaskListFromFile = personService.setAllowTaskForPerson(fromFileYear);
        List<Task> newTaskListToPerson;
        Person currentPerson;
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        List<Task> tasks = taskService.getAll();
        for (int k = 0; k < tasks.size(); k++) {
            if (tasks.get(k).getTimeToLive() == 12L) {
                historyAnalyseTaskService.createHistoryByTask(yesterday, tasks.get(k));
                tasks.get(k).setQuantitySuccess((int) (Math.random() * 10));
                taskService.updateTask(tasks.get(k));
            }
        }

        for (int q = 0; q < personList.size(); q++) {
            currentPerson = personList.get(q);
            newTaskListToPerson = personService.joinLists(currentPerson.getAllowTaskList(), newTaskListFromFile);
            currentPerson.setAllowTaskList(newTaskListToPerson);
            personService.updatePerson(currentPerson);
        }
    }
}
