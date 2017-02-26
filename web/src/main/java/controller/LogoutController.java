package controller;

import bean.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    private static Logger logger = Logger.getLogger(LogoutController.class);

    @RequestMapping("/logout")
    public String execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        logger.info("logout: " + user.getLogin());
        //delete the session
        req.getSession().invalidate();
        return "index";
    }
}