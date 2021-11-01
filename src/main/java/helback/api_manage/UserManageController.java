package helback.api_manage;

import helback.models.User;
import helback.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API (api-manage) для класса User
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/manage/user")
@Api(value = "/manage/user", tags = {"Manage Контроллер сущности User"})
public class UserManageController {

    private final UserService userService;

    @Autowired
    public UserManageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Вывести данные о users")
    public List<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Вывести User по id")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Создать User")
    public ResponseEntity addUser(@RequestBody User user,
                                  @RequestParam(value = "role") List<Integer> roleIdList) {
        // добавлени ролей пользователю и потом создать
        // приходит список с id
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    @ApiOperation(value = "Изменить User")
    public ResponseEntity updateUser(@RequestBody User user) {
        // как менять роли пользователям
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удалить User по id")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
