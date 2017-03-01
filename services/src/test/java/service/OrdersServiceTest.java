package service;

import bean.Goods;
import bean.Order;
import bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.interfaces.GoodsServiceInterface;
import service.interfaces.OrdersServiceInterface;
import service.interfaces.UserServiceInterface;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class OrdersServiceTest {
    @Autowired
    private OrdersServiceInterface orderService;
    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private GoodsServiceInterface goodsService;

    @Test
    public void saveGoods() {
        Order order = new Order(2);
        User user = userService.get(1);
        Goods goods = goodsService.get(1);
        order.setUser(user);
        order.setGoods(goods);
        List<Order> list = orderService.getAll();
        int sizeBefore = list.size();
        orderService.saveOrUpdate(order);
        list = orderService.getAll();
        int sizeAfter = list.size();
        assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getGoodsById() {
        Order order = orderService.get(9);
        assertEquals("Not got", 9, order.getId());
    }

    @Test
    public void deleteGoods() {
        Order tmp = new Order(2);
        User user = userService.get(1);
        Goods goods = goodsService.get(1);
        tmp.setUser(user);
        tmp.setGoods(goods);
        orderService.saveOrUpdate(tmp);

        List<Order> list = orderService.getAll();
        int sizeBefore = list.size();
        Order roleEntity = orderService.get(list.get(sizeBefore - 1).getId());
        orderService.delete(roleEntity);
        list = orderService.getAll();
        int sizeAfter = list.size();
        assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }

    @Test
    public void oldNewOrders() {
        User user = userService.get(98);
        List<Order> oldOrders = orderService.getAllOldOrNewOrdersByUsersId(user, true);
        List<Order> newOrders = orderService.getAllOldOrNewOrdersByUsersId(user, false);
        assertNotEquals(oldOrders, newOrders);
        assertNotNull(oldOrders);
        assertNotNull(newOrders);
    }
}
