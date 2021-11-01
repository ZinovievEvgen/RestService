package helback.dao_abstract;

import helback.models.User;

import java.util.Optional;

public interface UserDao extends GenericDao<Long, User> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
