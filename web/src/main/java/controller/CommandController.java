package controller;

import bean.Order;
import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IOrdersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Command controller
 */
@Controller
public class CommandController {
    @Autowired
    private IOrdersService ordersService;

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
            ordersService.addGoodsToBasket(goodsId, user);
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
        ordersService.delete(ordersId);
    }

    /**
     * Buy command. Buy all goods in basket
     * @param session - HttpSession
     */
    @RequestMapping("/buy")
    public String buyBasket(HttpSession session) {
        List<Order> list = (List<Order>) session.getAttribute("ordersList");
        //Mark orders like old
        ordersService.setIsPayed(list);
        session.removeAttribute("ordersList");
        session.setAttribute("message", "Спасибо за покупку. В ближайшее время с вами свяжется оператор.");
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
        ordersService.changeAmount(ordersId, count);
    }
}
