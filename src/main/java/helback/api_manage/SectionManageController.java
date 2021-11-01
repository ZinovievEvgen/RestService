package helback.api_manage;

import helback.dto.SectionDTO;
import helback.service.SectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса Section
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/section")
@Api(value = "/manage/section", tags = {"Manage Контроллер сущности Section(Разделы)"})
public class SectionManageController {

    private final SectionService sectionService;

    @Autowired
    public SectionManageController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести section по id")
    public SectionDTO getSectionById(@PathVariable long id) {
        return sectionService.getSectionDTOById(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать section")
    public ResponseEntity addSection(@RequestBody SectionDTO sectionDTO) {
        try {
            sectionService.addSection(sectionDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести все section")
    public List<SectionDTO> getAllSection() {
        return sectionService.getAllSection();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить section по id")
    public void deleteSectionById(@PathVariable Long id) {
        sectionService.deleteSectionById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить section")
    public void updateSection(@RequestBody SectionDTO sectionDTO) {
        sectionService.updateSection(sectionDTO);
    }
}
