package service;

import bean.Order;
import bean.User;
import dao.interfaces.OrdersDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.OrdersServiceInterface;
import service.interfaces.UserServiceInterface;

import java.io.Serializable;
import java.util.List;

/**
 * Service for orders. Singleton.
 */
@Service("orderService")
@Transactional
public class OrdersService implements OrdersServiceInterface {
    @Autowired
    private  OrdersDAOInterface ordersDAO;
    @Autowired
    private  UserServiceInterface userService;

    @Override
    public void saveOrUpdate(Order obj) {
        ordersDAO.saveOrUpdate(obj);
    }

    @Override
    public Order get(Serializable obj) {
        return ordersDAO.get(obj);
    }

    @Override
    public Order get(int id) {
        return ordersDAO.get(id);
    }

    @Override
    public void delete(Order order) {
        ordersDAO.delete(order);
    }

    @Override
    public List<Order> getAll() {
        return ordersDAO.getAll();
    }

    public List<Order> getAllOldOrNewOrdersByUsersId(User user, boolean old) {
        return ordersDAO.getAllOldOrNewOrdersByUsersId(user, old);
    }
}