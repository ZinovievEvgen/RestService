package helback.schedule_service_impl;

import helback.models.Person;
import helback.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Слой бизнес логики (Service)
 * класс реализация ScheduleService для сущности Task
 */

@EnableScheduling
@Service
public class GlobalTaskScheduleService {

    private final DailyTaskServiceImpl dailyTaskService;
    private final MonthTaskServiceImpl monthTaskService;
    private final SpecialTaskServiceImpl specialTaskService;
    private final YearTaskServiceImpl yearTaskService;
    private final PersonService personService;

    @Autowired
    public GlobalTaskScheduleService(DailyTaskServiceImpl dailyTaskService, MonthTaskServiceImpl monthTaskService, SpecialTaskServiceImpl specialTaskService, YearTaskServiceImpl yearTaskService, PersonService personService) {
        this.dailyTaskService = dailyTaskService;
        this.monthTaskService = monthTaskService;
        this.specialTaskService = specialTaskService;
        this.yearTaskService = yearTaskService;
        this.personService = personService;
    }

    /**
     * метод - обновление дневных тасков
     * выводит каждые 120 секунд - потом изменить на нужное время
     * <p>
     * порядок обновления:
     * 1. обновление доступных задач
     * 2. обновление список выполненных задач
     * 3. проверка начатых задач
     * 4. добавление задач по ид из файла
     * 5. принудительно стартануть задачи на шаги (для ежедневных)
     */
    //@Scheduled(fixedRate = 200000)
    @Scheduled(cron = "0 0 3 * * *")
    public void updateDailyTasks() {
        dailyTaskService.refreshAllowTaskList();
        dailyTaskService.refreshCompleteTaskList();
        dailyTaskService.closeStartedTask();
        dailyTaskService.addNewTasks();

        for (Person person : personService.getAllPerson()) {
            dailyTaskService.startStepTask(person.getUniqueId());
        }
    }

    // метод - обновление месяных тасков
    public void updateMonthTasks() {
        monthTaskService.refreshAllowTaskList();
        monthTaskService.refreshCompleteTaskList();
        monthTaskService.closeStartedTask();
        monthTaskService.addNewTasks();
    }

    /**
     * метод - обновление ежегодных тасков
     * выводит каждые 180 секунд - потом изменить на нужное время
     * <p>
     * порядок обновления:
     * 1. обновление доступных задач
     * 2. обновление список выполненных задач
     * 3. проверка начатых задач
     * 4. добавление задач по ид из файла
     */
    //@Scheduled(cron = "0 0 0 20 1 ?")
    @Scheduled(fixedRate = 180000)
    public void updateYearTasks() {
        yearTaskService.refreshAllowTaskList();
        yearTaskService.refreshCompleteTaskList();
        yearTaskService.closeStartedTask();
        yearTaskService.addNewTasks();
    }

    // метод - обновление специальных тасков для пользователей
    public void updateSpecialTasks() {
        // добавить функционал при необходимости
    }
}
