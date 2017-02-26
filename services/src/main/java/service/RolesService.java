package service;

import bean.Role;
import dao.interfaces.RolesDAOInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.RolesServiceInterface;

import java.io.Serializable;
import java.util.List;

/**
 * Service for role. Singleton.
 */
@Service("roleService")
@Transactional
public class RolesService implements RolesServiceInterface {

    @Autowired
    private  RolesDAOInterfaces rolesDAO;

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