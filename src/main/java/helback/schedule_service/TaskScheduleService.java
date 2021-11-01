package helback.schedule_service;

/**
 * Слой бизнес логики (Service)
 * интерфейс service для сущности Task (запуск по расписанию)
 */
public interface TaskScheduleService {

    // метод - удалить доступные таски
    void refreshAllowTaskList();

    // метод - очистить список выполненных тасков
    void refreshCompleteTaskList();

    //метод - закрыть начатые таски
    void closeStartedTask();

    //метод - добавляем задачи по ид из файла
    void addNewTasks();

}
