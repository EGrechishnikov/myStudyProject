package dao.impl;

import bean.Role;
import dao.IRolesDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DAO for roles
 */
@Repository
public class RolesDAO extends BaseDAO<Role> implements IRolesDAO {
    @Autowired
    public RolesDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}