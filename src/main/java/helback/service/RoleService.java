package helback.service;

import helback.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    RoleDTO getRoleById(Long id);

    RoleDTO findByName(String name);

    void addRole(RoleDTO roleDTO);

    List<RoleDTO> getAllRole();

    void deleteRoleById(Long id);

    void updateRole(RoleDTO roleDTO);
}
