package controller;

import bean.Goods;
import bean.Order;
import bean.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IGoodsService;
import service.IOrdersService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * My page controller
 */
@Controller
public class MyPageController {
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IGoodsService goodsService;
    private static Logger logger = Logger.getLogger(MyPageController.class);

    /**
     * Show my page with my orders
     * @param session - HttpSession
     * @return - link
     */
    @RequestMapping("/my")
    public String myPageShow(HttpSession session) {
        //Search user in the session
        try {
            User user = (User) session.getAttribute("user");
            session.setAttribute("jsp_message", user.toString());
            //Add goods list in user session
            List<Order> newOrders = ordersService.getAllOldOrNewOrdersByUsersId(user, false); //new order
            List<Order> oldOrders = ordersService.getAllOldOrNewOrdersByUsersId(user, true);  //list of old orders
            List<Goods> catalog = goodsService.getAll();                                //catalog
            session.removeAttribute("oldOrders");
            session.setAttribute("ordersList", newOrders);
            session.setAttribute("catalog", catalog);
            session.setAttribute("oldOrders", oldOrders);
        } catch (Exception e) {
            logger.error(e);
            session.setAttribute("jsp_error", "ошибка логина");
        }
        return "myPage";
    }
}
