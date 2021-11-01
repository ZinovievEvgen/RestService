package helback.dao_impl;

import helback.dao_abstract.HistoryAnalyseTaskDao;
import helback.models.HistoryAnalyseTask;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности HistoryAnalyseTask
 */
@Transactional
@Repository
public class HistoryAnalyseTaskDaoImpl extends AbstractDao<Long, HistoryAnalyseTask> implements HistoryAnalyseTaskDao {
    @Override
    public List<HistoryAnalyseTask> getAllHistoryAnalyseTaskForPeriod(LocalDate start, LocalDate end) {
        return (List<HistoryAnalyseTask>) entityManager.createQuery("select h.date, h.task.description, h.countToComplete from HistoryAnalyseTask h join h.task ta where h.date between :startDate and :endDate order by h.date")
                .setParameter("startDate", start)
                .setParameter("endDate", end)
                .getResultList();
    }

    @Override
    public List<HistoryAnalyseTask> getHistoryByPersonForPeriod(String un, LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public List<HistoryAnalyseTask> getHistoryByPerson(String un) {
        return null;
    }
}
