package helback.dao_abstract;

import helback.models.HistoryAnalyseTask;

import java.time.LocalDate;
import java.util.List;

/**
 * Слой ДАО
 * интерфейс ДАО для HistoryAnalyseTask
 */
public interface HistoryAnalyseTaskDao extends GenericDao<Long, HistoryAnalyseTask> {

    List<HistoryAnalyseTask> getAllHistoryAnalyseTaskForPeriod(LocalDate start, LocalDate end);

    List<HistoryAnalyseTask> getHistoryByPersonForPeriod(String un, LocalDate start, LocalDate end);

    List<HistoryAnalyseTask> getHistoryByPerson(String un);
}
