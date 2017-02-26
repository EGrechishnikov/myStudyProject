package service;

import bean.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.RolesServiceInterface;

import java.util.List;
import static org.junit.Assert.assertEquals;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class RolesServiceTest {
    @Autowired
    private RolesServiceInterface rolesService;

    @Test
    public void saveRole() {
        Role role = new Role("daoTest");
        List<Role> list = rolesService.getAll();
        int sizeBefore = list.size();
        rolesService.saveOrUpdate(role);
        list = rolesService.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getRoleById() {
        Role role = rolesService.get(1);
        assertEquals("Not got", "admin", role.getName());
    }

    @Test
    public void deleteRole() {
        List<Role> list = rolesService.getAll();
        int sizeBefore = list.size();
        Role role = rolesService.get(3);
        rolesService.delete(role);
        list = rolesService.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
