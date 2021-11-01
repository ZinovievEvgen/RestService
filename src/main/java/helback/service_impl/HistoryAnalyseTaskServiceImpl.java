package helback.service_impl;

import helback.dao_abstract.HistoryAnalyseTaskDao;
import helback.models.HistoryAnalyseTask;
import helback.models.Task;
import helback.service.HistoryAnalyseTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Слой бизнес логики (Service)
 * класс реализация service для сущности HistoryAnalyseTask
 */
@Service
public class HistoryAnalyseTaskServiceImpl implements HistoryAnalyseTaskService {


    private final HistoryAnalyseTaskDao historyAnalyseTaskDao;

    @Autowired
    public HistoryAnalyseTaskServiceImpl(HistoryAnalyseTaskDao historyAnalyseTaskDao) {
        this.historyAnalyseTaskDao = historyAnalyseTaskDao;
    }

    @Override
    public HistoryAnalyseTask getHistoryAnalyseTaskById(Long id) {
        return historyAnalyseTaskDao.getByKey(id);
    }

    @Override
    public void addHistoryAnalyseTask(HistoryAnalyseTask historyAnalyseTask) {
        try {
            historyAnalyseTaskDao.persist(historyAnalyseTask);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при добавлении сущности HistoryAnalyseTask");
        }
    }

    @Override
    public List<HistoryAnalyseTask> getAllHistoryAnalyseTask() {
        return historyAnalyseTaskDao.getAll();
    }

    @Override
    public List<HistoryAnalyseTask> getAllHistoryAnalyseTaskForPeriod(LocalDate start, LocalDate end) {
        return historyAnalyseTaskDao.getAllHistoryAnalyseTaskForPeriod(start, end);
    }

    @Override
    public List<HistoryAnalyseTask> getHistoryByPersonForPeriod(String un, LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public List<HistoryAnalyseTask> getHistoryByPerson(String un) {
        return null;
    }

    @Override
    public void createHistoryByTask(LocalDate date, Task task) {
        historyAnalyseTaskDao.persist(new HistoryAnalyseTask(date, task, task.getQuantitySuccess()));
    }
}

