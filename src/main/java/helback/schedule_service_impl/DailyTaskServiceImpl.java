package helback.schedule_service_impl;

import helback.models.Person;
import helback.models.Task;
import helback.schedule_service.TaskScheduleService;
import helback.service.CompleteListTaskService;
import helback.service.HistoryAnalyseTaskService;
import helback.service.PersonService;
import helback.service.TaskService;
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
public class DailyTaskServiceImpl implements TaskScheduleService {

    @Value("${PATH_FROM_FILE}")
    private String fromFile;

    private final CompleteListTaskService completeListTaskService;
    private final PersonService personService;
    private final TaskService taskService;
    private final HistoryAnalyseTaskService historyAnalyseTaskService;

    @Autowired
    public DailyTaskServiceImpl(CompleteListTaskService completeListTaskService, PersonService personService, TaskService taskService, HistoryAnalyseTaskService historyAnalyseTaskService) {
        this.completeListTaskService = completeListTaskService;
        this.personService = personService;
        this.taskService = taskService;
        this.historyAnalyseTaskService = historyAnalyseTaskService;
    }

    /**
     * порядок обновления:
     * 1. проверяем список доступных задач (ттл = 3), если не пустой - редактируем ХП - очищаем
     * 2. проверяем список выполненных задач (ттл = 3), если не пустой - очищаем
     * 3. проверяем начатые задачи, если есть - очищаем
     * 4. считываем из файла ид задач и добавляем в имеющийся список к годовым и т.д, обновляем данные по количеству выполнений
     */

    @Override
    public void refreshAllowTaskList() {
        List<Task> notCompleteTaskList = new ArrayList<>();
        List<Person> personList = personService.getAllPerson();

        for (int a = 0; a < personList.size(); a++) {
            for (int b = 0; b < personList.get(a).getAllowTaskList().size(); b++) {
                if (personList.get(a).getAllowTaskList().get(b).getTimeToLive() == 3L) {
                    notCompleteTaskList.add(personList.get(a).getAllowTaskList().get(b));
                }
            }

            if (!notCompleteTaskList.isEmpty()) {
                personService.updateHealtyPointByPerson(personList.get(a), notCompleteTaskList);
                for (int c = 0; c < notCompleteTaskList.size(); c++) {
                    //personService.getAllPerson().get(a).removeAllowTask(notCompleteTaskList.get(c));
                    personService.deleteTaskOnAllowTaskList(personList.get(a), notCompleteTaskList.get(c));
                }
                notCompleteTaskList.clear();
            }
        }
    }

    @Override
    public void refreshCompleteTaskList() {
        List<Task> completeTaskListByPerson;
        List<Task> completeDailyTaskList = new ArrayList<>();
        List<Person> personList = personService.getAllPerson();

        for (int d = 0; d < personList.size(); d++) {
            completeTaskListByPerson = completeListTaskService.getAllCompleteTaskByPerson(personList.get(d).getId());

            for (int e = 0; e < completeTaskListByPerson.size(); e++) {
                if (completeTaskListByPerson.get(e).getTimeToLive() == 3L) {
                    completeDailyTaskList.add(completeTaskListByPerson.get(e));
                }
            }

            System.out.println("В списке completeDailyTaskList занесены следующие таски:");
            for (Task task : completeDailyTaskList) {
                System.out.println(task.getId());
            }

            if (!completeDailyTaskList.isEmpty()) {
                for (int f = 0; f < completeDailyTaskList.size(); f++) {
                    personService.clearCompleteTaskList(personList.get(d), completeDailyTaskList.get(f));
                }
                completeDailyTaskList.clear();
            }
        }
    }

    @Override
    public void closeStartedTask() {
        List<Task> notCompleteDailyTaskList;
        List<Person> personList = personService.getAllPerson();

        for (int i = 0; i < personList.size(); i++) {
            notCompleteDailyTaskList = completeListTaskService.getAllOpenCompleteTaskByPerson(personList.get(i).getId(),
                    LocalDate.now().minusDays(1).atTime(3, 0, 0),
                    LocalDate.now().atTime(2, 59, 59));

            if (!notCompleteDailyTaskList.isEmpty()) {
                for (int j = 0; j < notCompleteDailyTaskList.size(); j++) {
                    completeListTaskService.deleteByPersonAndTask(personList.get(i), notCompleteDailyTaskList.get(j));
                }
                notCompleteDailyTaskList.clear();
            }
        }
    }


    @Override
    public void addNewTasks() {
        List<Person> personList = personService.getAllPerson();
        List<Task> newTaskListFromFile = personService.setAllowTaskForPerson(fromFile);
        List<Task> newTaskListToPerson;
        Person currentPerson;
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        List<Task> tasks = taskService.getAll();
        for (int k = 0; k < tasks.size(); k++) {
            if (tasks.get(k).getTimeToLive() == 3L) {
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

    void startStepTask(String un) {
        completeListTaskService.addCreateTimeTask(un, 6L);
    }
}