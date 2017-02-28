package controller;

import bean.Goods;
import bean.Order;
import bean.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.interfaces.GoodsServiceInterface;
import service.interfaces.OrdersServiceInterface;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Command controller
 */
@Controller
public class CommandController {
    @Autowired
    private OrdersServiceInterface ordersService;
    @Autowired
    private GoodsServiceInterface goodsService;
    private static Logger logger = Logger.getLogger(CommandController.class);

    /**
     * Add command. Add goods in basket
     * @param req - HttpServletRequest
     */
    @RequestMapping("/add")
    public void addToBasket(HttpServletRequest req) {
        try {
            User user = (User) req.getSession().getAttribute("user");
            if(user == null) {
                throw new Exception();
            }
            int goodsId = Integer.parseInt(req.getParameter("id"));
            Goods goods = goodsService.get(goodsId);
            Order order = new Order(0, "n");
            order.setGoods(goods);
            order.setUser(user);
            ordersService.saveOrUpdate(order);
        } catch (Exception e) {
            req.getSession().setAttribute("message", "Войдите в систему, что бы сделать покупку.");
        }
    }

    /**
     * Sub command. Delete goods from basket
     * @param req - HttpServletRequest
     */
    @RequestMapping("/sub")
    public void deleteFromBasket(HttpServletRequest req) {
        int ordersId = Integer.parseInt(req.getParameter("id"));
        Order order = ordersService.get(ordersId);
        ordersService.delete(order);
    }

    /**
     * Buy command. Buy all goods in basket
     * @param req - HttpServletRequest
     */
    @RequestMapping("/buy")
    public String buyBasket(HttpServletRequest req) {
        List<Order> list = (List<Order>) req.getSession().getAttribute("ordersList");
        //Mark orders like old
        for (Order o : list) {
            logger.warn("order's id: " + o.getId());
            o = ordersService.get(o.getId());
            o.setIsPayed("y");
            logger.warn("amount: " + o.getAmount());
            ordersService.saveOrUpdate(o);
        }
        req.getSession().removeAttribute("ordersList");
        req.getSession().setAttribute("message", "Спасибо за покупку. В ближайшее время с вами свяжется оператор.");
        return "order";
    }

    /**
     * Change command. Change count of goods
     * @param ordersId - order's index
     * @param count - new count
     */
    @RequestMapping("/change")
    public void changeAmount(@RequestParam("id") int ordersId,
                             @RequestParam("count") int count) {
        Order order = ordersService.get(ordersId);
        order.setAmount(count);
        ordersService.saveOrUpdate(order);
    }
}
