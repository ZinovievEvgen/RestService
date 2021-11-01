package helback.service_impl;

import helback.dao_abstract.RoleDao;
import helback.dto.RoleDTO;
import helback.mapper.RoleMapper;
import helback.models.Role;
import helback.service.RoleService;
import helback.utils.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleDao roleDao;
    private final RoleMapper roleMapper;
    private final CopyService copyService;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, RoleMapper roleMapper, CopyService copyService) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
        this.copyService = copyService;
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return roleMapper.toDto(roleDao.getByKey(id));
    }

    @Override
    public RoleDTO findByName(String name) {
        return roleMapper.toDto(roleDao.findByName(name)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
    }

    @Override
    public void addRole(RoleDTO roleDTO) {
        roleDao.persist(roleMapper.toEntity(roleDTO));
    }

    @Override
    public List<RoleDTO> getAllRole() {
        return roleMapper.toDto(roleDao.getAll());
    }

    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteByKey(id);
    }

    @Override
    public void updateRole(RoleDTO roleDTO) {

        try {
            Role updateRole = roleDao.getByKey(roleDTO.getId());
            roleMapper.updateEFromD(roleDTO, updateRole);
            roleDao.update(updateRole);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при обновлении типа задачи");
        }
    }
}
