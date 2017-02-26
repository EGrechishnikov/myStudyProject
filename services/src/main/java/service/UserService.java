package service;

import bean.User;
import dao.interfaces.UsersDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.UserServiceInterface;

import java.io.Serializable;
import java.util.List;

/**
 * Service for users. Singleton.
 */
@Service("userService")
@Transactional
public class UserService implements UserServiceInterface {
    @Autowired
    private UsersDAOInterface usersDAO;

    @Override
    public void saveOrUpdate(User bean) {
        usersDAO.saveOrUpdate(bean);
    }

    @Override
    public User get(Serializable obj) {
        return usersDAO.get(obj);
    }

    @Override
    public User get(int id) {
        return usersDAO.get(id);
    }

    @Override
    public void delete(User user) {
        usersDAO.delete(user);
    }

    @Override
    public List<User> getAll() {
        return usersDAO.getAll();
    }

    public User get(String login) {
        return usersDAO.get(login);
    }

    public boolean isEmailExist(String email) {
        return usersDAO.isEmailExist(email);
    }

    public boolean isLoginExist(String login) {
        return usersDAO.isLoginExist(login);
    }
}