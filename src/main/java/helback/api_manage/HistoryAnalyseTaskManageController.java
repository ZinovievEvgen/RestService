package helback.api_manage;

import helback.models.HistoryAnalyseTask;
import helback.service.HistoryAnalyseTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса HistoryAnalyseTask
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/history")
@Api(value = "/manage/history", tags = {"Manage Контроллер сущности HistoryAnalyseTask(анализ выполнения заданий)"})
public class HistoryAnalyseTaskManageController {

    private final HistoryAnalyseTaskService historyAnalyseTaskService;

    @Autowired
    public HistoryAnalyseTaskManageController(HistoryAnalyseTaskService historyAnalyseTaskService) {
        this.historyAnalyseTaskService = historyAnalyseTaskService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести данные о выполнениях заданий")
    public List<HistoryAnalyseTask> getAllHistoryAnalyseTask() {
        return historyAnalyseTaskService.getAllHistoryAnalyseTask();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести HistoryAnalyseTask по id")
    public HistoryAnalyseTask getHistoryAnalyseTaskById(@PathVariable Long id) {
        return historyAnalyseTaskService.getHistoryAnalyseTaskById(id);
    }
    // аналитика пользователей

    //get-history with person-ins tasks
    @GetMapping("/get-history")
    @ApiOperation(value = "Вывести данные о выполненных заданий пользователя")
    public List<HistoryAnalyseTask> getHistoryByPerson(@RequestParam(value = "un") String un) {
        return null;
    }
}
