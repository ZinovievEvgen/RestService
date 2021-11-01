package helback.api_manage;


import helback.dto.RoleDTO;
import helback.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса Role
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/role")
@Api(value = "/manage/role", tags = {"Manage Контроллер сущности Role(роли пользователей)"})
public class RoleManageController {

    private final RoleService roleService;

    @Autowired
    public RoleManageController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести данные о ролях")
    public List<RoleDTO> getAllRole() {
        return roleService.getAllRole();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести Role по id")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать Role")
    public ResponseEntity addRole(@RequestBody RoleDTO roleDTO) {
        roleService.addRole(roleDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить Role")
    public ResponseEntity updateRole(@RequestBody RoleDTO roleDTO) {
        roleService.updateRole(roleDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить Role по id")
    public ResponseEntity deleteRole(@PathVariable long id) {
        roleService.deleteRoleById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
