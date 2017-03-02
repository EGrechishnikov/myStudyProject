package service;

import bean.Order;
import bean.User;

import java.util.List;

public interface IOrdersService extends IBaseService<Order> {
    /**
     * Delete order by id
     * @param id - index
     */
    void delete(int id);

    /**
     * Get all orders by users id. Old or new
     *
     * @param user  - users bean
     * @param old - true for old orders
     * @return - list
     */
    List<Order> getAllOldOrNewOrdersByUsersId(User user, boolean old);

    /**
     * Add goods by id to basket
     * @param goodsId - goods id
     * @param user - user
     */
    void addGoodsToBasket(int goodsId, User user);

    /**
     * Make order payed by id
     * @param list - order list
     */
    void setIsPayed(List<Order> list);

    /**
     * Change amount of order
     * @param ordersId - order index
     * @param count - amount
     */
    void changeAmount(int ordersId, int count);
}
