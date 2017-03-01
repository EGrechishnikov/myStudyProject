package dao;

import bean.Goods;
import bean.Order;
import bean.User;
import dao.interfaces.GoodsDAOInterface;
import dao.interfaces.OrdersDAOInterface;
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class OrdersDAOTest {
    @Autowired
    private OrdersDAOInterface ordersDAO;
    @Autowired
    private UsersDAOInterface usersDAO;
    @Autowired
    private GoodsDAOInterface goodsDAO;

    @Test
    public void saveGoods() {
        Order order = new Order(2);
        User user = usersDAO.get(1);
        Goods goods = goodsDAO.get(1);
        order.setUser(user);
        order.setGoods(goods);
        List<Order> list = ordersDAO.getAll();
        int sizeBefore = list.size();
        ordersDAO.saveOrUpdate(order);
        list = ordersDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getGoodsById() {
        Order order = ordersDAO.get(9);
        assertEquals("Not got", 9, order.getId());
    }

    @Test
    public void deleteGoods() {
        Order tmp = new Order(2);
        User user = usersDAO.get(1);
        Goods goods = goodsDAO.get(1);
        tmp.setUser(user);
        tmp.setGoods(goods);
        ordersDAO.saveOrUpdate(tmp);

        List<Order> list = ordersDAO.getAll();
        int sizeBefore = list.size();
        Order roleEntity = ordersDAO.get(list.get(sizeBefore - 1).getId());
        ordersDAO.delete(roleEntity);
        list = ordersDAO.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }

    @Test
    public void oldNewOrders() {
        User user = usersDAO.get(98);
        List<Order> oldOrders = ordersDAO.getAllOldOrNewOrdersByUsersId(user, true);
        List<Order> newOrders = ordersDAO.getAllOldOrNewOrdersByUsersId(user, false);
        assertNotEquals(oldOrders, newOrders);
        assertNotNull(oldOrders);
        assertNotNull(newOrders);
    }
}
