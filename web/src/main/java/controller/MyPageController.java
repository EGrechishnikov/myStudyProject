package controller;

import bean.Goods;
import bean.Order;
import bean.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.interfaces.GoodsServiceInterface;
import service.interfaces.OrdersServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPageController {
    @Autowired
    private OrdersServiceInterface ordersService;
    @Autowired
    private GoodsServiceInterface goodsService;
    private static Logger logger = Logger.getLogger(MyPageController.class);

    @RequestMapping("/my")
    public String myPageShow(HttpServletRequest req) {
        //Search user in the session
        HttpSession session = req.getSession(true);
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