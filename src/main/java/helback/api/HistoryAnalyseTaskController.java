package helback.api;

import helback.models.HistoryAnalyseTask;
import helback.service.HistoryAnalyseTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST API (api) для класса HistoryAnalyseTask
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/history")
@Api(value = "/history", tags = {"Контроллер сущности HistoryAnalyseTask(анализ выполнения заданий)"})
public class HistoryAnalyseTaskController {

    private final HistoryAnalyseTaskService historyAnalyseTaskService;

    @Autowired
    public HistoryAnalyseTaskController(HistoryAnalyseTaskService historyAnalyseTaskService) {
        this.historyAnalyseTaskService = historyAnalyseTaskService;
    }

    //get-history with person-ins tasks by particular period
    @GetMapping("/get-history-time")
    @ApiOperation(value = "Вывести данные о выполненных заданий пользователя за конкретный период")
    public List<HistoryAnalyseTask> getHistoryByPersonForPeriod(@RequestParam(value = "un") String un,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return null;
    }

    @GetMapping("/all-period")
    @ApiOperation(value = "Вывести данные о выполнениях заданий за определенный период")
    public List<HistoryAnalyseTask> getAllHistoryAnalyseTaskForPeriod(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return historyAnalyseTaskService.getAllHistoryAnalyseTaskForPeriod(start, end);
    }
}
