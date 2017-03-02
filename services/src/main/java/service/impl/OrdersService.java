package service.impl;

import bean.Goods;
import bean.Order;
import bean.User;
import dao.IOrdersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IGoodsService;
import service.IOrdersService;

import java.io.Serializable;
import java.util.List;

/**
 * Service for orders.
 */
@Service("orderService")
@Transactional
public class OrdersService implements IOrdersService {
    @Autowired
    private IOrdersDAO ordersDAO;
    @Autowired
    private IGoodsService goodsService;

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
    public void delete(int id) {
        delete(get(id));
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

    @Override
    public void addGoodsToBasket(int goodsId, User user) {
        Goods goods = goodsService.get(goodsId);
        Order order = new Order(0);
        order.setGoods(goods);
        order.setUser(user);
        saveOrUpdate(order);
    }

    @Override
    public void setIsPayed(List<Order> list) {
        for(Order o : list) {
            Order order = get(o.getId());
            order.setIsPayed();
            saveOrUpdate(order);
        }
    }

    @Override
    public void changeAmount(int ordersId, int count) {
        Order order = get(ordersId);
        order.setAmount(count);
        saveOrUpdate(order);
    }
}