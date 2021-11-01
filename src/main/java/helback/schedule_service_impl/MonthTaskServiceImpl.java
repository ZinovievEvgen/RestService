package helback.schedule_service_impl;

import helback.schedule_service.TaskScheduleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Слой бизнес логики (Service)
 * класс реализация ScheduleService для сущности Task
 */
@Service
public class MonthTaskServiceImpl implements TaskScheduleService {

    @Value("${PATH_FROM_FILE_MON}")
    private String fromFileMon;


    @Override
    public void refreshAllowTaskList() {

    }

    @Override
    public void refreshCompleteTaskList() {

    }

    @Override
    public void closeStartedTask() {

    }

    @Override
    public void addNewTasks() {

    }
}
