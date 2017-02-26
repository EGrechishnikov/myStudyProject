package dao;

import bean.Role;
import dao.interfaces.RolesDAOInterfaces;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class RolesDAOTest {
    @Autowired
    private RolesDAOInterfaces rolesDAO;

    @Test
    public void saveRole() {
        Role role = new Role("daoTest");
        List<Role> list = rolesDAO.getAll();
        int sizeBefore = list.size();
        rolesDAO.saveOrUpdate(role);
        list = rolesDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getRoleById() {
        Role role = rolesDAO.get(1);
        assertEquals("Not got", "admin", role.getName());
    }

    @Test
    public void deleteRole() {
        List<Role> list = rolesDAO.getAll();
        int sizeBefore = list.size();
        Role role = rolesDAO.get(3);
        rolesDAO.delete(role);
        list = rolesDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
