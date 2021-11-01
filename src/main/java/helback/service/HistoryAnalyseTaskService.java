package helback.service;

import helback.models.HistoryAnalyseTask;
import helback.models.Role;
import helback.models.Task;

import java.time.LocalDate;
import java.util.List;

/**
 * Слой бизнес логики (Service)
 * интерфейс service для сущности HistoryAnalyseTask
 */
public interface HistoryAnalyseTaskService {

    HistoryAnalyseTask getHistoryAnalyseTaskById(Long id);

    void addHistoryAnalyseTask(HistoryAnalyseTask historyAnalyseTask);

    List<HistoryAnalyseTask> getAllHistoryAnalyseTask();

    List<HistoryAnalyseTask> getAllHistoryAnalyseTaskForPeriod(LocalDate start, LocalDate end);

    List<HistoryAnalyseTask> getHistoryByPersonForPeriod(String un, LocalDate start, LocalDate end);

    List<HistoryAnalyseTask> getHistoryByPerson(String un);

    void createHistoryByTask(LocalDate date, Task task);
}
