package helback.dao_impl;

import helback.dao_abstract.RoleDao;
import helback.models.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Слой ДАО
 * класс реализация ДАО для сущности Role
 */
@Transactional
@Repository
public class RoleDaoImpl extends AbstractDao<Long, Role> implements RoleDao {
    @Override
    public Optional<Role> findByName(String name) {
        String query = "select c from Role c where c.name = :name";
        return entityManager.unwrap(Session.class)
                .createQuery(query, Role.class)
                .setParameter("name", name)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }
}
