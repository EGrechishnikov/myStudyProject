package dao.impl;

import bean.User;
import dao.IUsersDAO;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DAO for users
 */
@Repository
public class UsersDAO extends BaseDAO<User> implements IUsersDAO {

    @Autowired
    public UsersDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public User get(String login) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    public boolean isEmailExist(String email) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        return null != criteria.uniqueResult();
    }

    public boolean isLoginExist(String login) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return null != criteria.uniqueResult();
    }
}
