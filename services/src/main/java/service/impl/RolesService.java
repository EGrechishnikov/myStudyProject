package service.impl;

import bean.Role;
import dao.IRolesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IRolesService;

import java.io.Serializable;
import java.util.List;

/**
 * Service for role.
 */
@Service("roleService")
@Transactional
public class RolesService implements IRolesService {

    @Autowired
    private IRolesDAO rolesDAO;

    @Override
    public void saveOrUpdate(Role obj) {
        rolesDAO.saveOrUpdate(obj);
    }

    @Override
    public Role get(Serializable obj) {
        return rolesDAO.get(obj);
    }

    @Override
    public Role get(int id) {
        return rolesDAO.get(id);
    }

    @Override
    public void delete(Role role) {
        rolesDAO.delete(role);
    }

    @Override
    public List<Role> getAll() {
        return rolesDAO.getAll();
    }
}