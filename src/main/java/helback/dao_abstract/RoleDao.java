package helback.dao_abstract;

import helback.models.Role;

import java.util.Optional;

public interface RoleDao extends GenericDao<Long, Role> {

    Optional<Role> findByName(String name);
}
