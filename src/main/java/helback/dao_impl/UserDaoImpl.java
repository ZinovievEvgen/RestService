package helback.dao_impl;

import helback.dao_abstract.UserDao;
import helback.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    @Override
    public Optional<User> findByUsername(String username) {
        String query = "select c from User c where c.username = :username";
        return entityManager.unwrap(Session.class)
                .createQuery(query, User.class)
                .setParameter("username", username)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "select c from User c where c.email = :email";
        return entityManager.unwrap(Session.class)
                .createQuery(query, User.class)
                .setParameter("email", email)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }
}
