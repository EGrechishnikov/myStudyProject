package service;

import bean.Role;
import bean.User;
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

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class UsersServiceTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRolesService rolesService;

    @Test
    public void saveUser() {
        Role role = rolesService.get(2);
        List<User> list = userService.getAll();
        int sizeBefore = list.size();
        User user = new User("author", "testPassword123", "email.@mail.ru", "+375448887755", "1233451iqhbdiabf");
        user.setRole(role);
        userService.saveOrUpdate(user);
        list = userService.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
        userService.delete(user);
    }

    @Test
    public void getUserById() {
        User user = userService.get(1);
        assertEquals("Not got", "admin", user.getLogin());
    }

    @Test
    public void deleteUser() {
        Role role = rolesService.get(2);
        User user = new User("author", "testPassword123", "email.@mail.ru", "+375448887755", "1233451iqhbdiabf");
        user.setRole(role);
        userService.saveOrUpdate(user);
        List<User> list = userService.getAll();
        int sizeBefore = list.size();
        User userEntity = userService.get(user.getLogin());
        userService.delete(userEntity);
        list = userService.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }

    @Test
    public void eExist() {
        assertTrue(userService.isEmailExist("superman@mail.ru"));
        assertTrue(userService.isLoginExist("batman"));
        assertFalse(userService.isEmailExist("1231"));
        assertFalse(userService.isLoginExist("1231§"));
    }
}
