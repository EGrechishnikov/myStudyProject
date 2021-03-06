package dao;

import bean.Order;
import bean.User;

import java.util.List;

public interface IOrdersDAO extends IBaseDAO<Order> {
    /**
     * Get all orders by users id. Old or new
     *
     * @param user - users bean
     * @param old  - true for old orders
     * @return - list
     */
    List<Order> getAllOldOrNewOrdersByUsersId(User user, boolean old);
}
