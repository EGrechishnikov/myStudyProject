package dao;

import bean.Order;
import bean.User;
import dao.interfaces.OrdersDAOInterface;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for orders
 */
@Repository
public class OrdersDAO extends BaseDAO<Order> implements OrdersDAOInterface {
    @Autowired
    public OrdersDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Order> getAllOldOrNewOrdersByUsersId(User user, boolean old) {
        String payed = old ? "y" : "n";
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("isPayed", payed));
        return criteria.list();
    }
}
