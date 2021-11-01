package helback.service;

import helback.models.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    void addUser(User user);

    List<User> getAllUser();

    void deleteUserById(Long id);

    void updateUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}
