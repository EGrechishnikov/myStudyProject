package controller;

import bean.User;
import filters.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.interfaces.UserServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserServiceInterface userService;
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("Login") String login,
                            @RequestParam("Password") String password,
                            HttpServletRequest req) {
        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            //Clear the answer
            req.getSession().removeAttribute("answer");
            return "login";
        }
        logger.info(String.format("Tries to enter: %s", login));
        //check data with regex
        if (login.matches(User.LOGIN_REGEX) && password.matches(User.PASSWORD_REGEX)) {
            //if alright then go to main page
            if (checkInDB(login, password, req)) {
                return "index";
            }
        }
        //else show the message
        req.getSession().setAttribute("answer", "Логин или пароль неверны");
        return "login";
    }

    /**
     * Check data in db
     *
     * @param login    - login
     * @param password - password
     * @param req      - requset
     * @return - true if such user is exist
     */
    private boolean checkInDB(String login, String password, HttpServletRequest req) {
        User user = userService.get(login);
        if (user == null) {
            return false;
        }
        password = Hex.getHex(password + user.getSalt());
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            //if alright then create a session
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            logger.info("Entered: " + user);
            return true;
        } else {
            return false;
        }
    }
}
