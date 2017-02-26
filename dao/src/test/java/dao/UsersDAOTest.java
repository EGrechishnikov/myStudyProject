package dao;

import bean.Role;
import bean.User;
import dao.interfaces.RolesDAOInterfaces;
import dao.interfaces.UsersDAOInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class UsersDAOTest {
    @Autowired
    private UsersDAOInterface usersDAO;
    @Autowired
    private RolesDAOInterfaces rolesDAO;

    @Test
    public void saveUser() {
        Role role = rolesDAO.get(2);
        List<User> list = usersDAO.getAll();
        int sizeBefore = list.size();
        User user = new User("author", "testPassword123", "email.@mail.ru", "+375448887755", "1233451iqhbdiabf");
        user.setRole(role);
        usersDAO.saveOrUpdate(user);
        list = usersDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
        usersDAO.delete(user);
    }

    @Test
    public void getUserById() {
        User user = usersDAO.get(1);
        assertEquals("Not got", "admin", user.getLogin());
    }

    @Test
    public void deleteUser() {
        Role role = rolesDAO.get(2);
        User user = new User("author", "testPassword123", "email.@mail.ru", "+375448887755", "1233451iqhbdiabf");
        user.setRole(role);
        usersDAO.saveOrUpdate(user);
        List<User> list = usersDAO.getAll();
        int sizeBefore = list.size();
        User userEntity = usersDAO.get(user.getLogin());
        usersDAO.delete(userEntity);
        list = usersDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }

    @Test
    public void eExist() {
        assertTrue(usersDAO.isEmailExist("superman@mail.ru"));
        assertTrue(usersDAO.isLoginExist("batman"));
        assertFalse(usersDAO.isEmailExist("1231"));
        assertFalse(usersDAO.isLoginExist("1231§"));
    }
}
