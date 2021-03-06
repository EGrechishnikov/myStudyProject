package controller;

import bean.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.IUserService;

/**
 * Sign up controller
 */
@Controller
public class SignUpController {
    @Autowired
    private IUserService userService;
    private static final Logger logger = Logger.getLogger(SignUpController.class);

    /**
     * Return link
     * @return - link
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage() {
        return "signup";
    }

    /**
     * Sign up command
     * @param login - login
     * @param password - password
     * @param email - email
     * @param phone - phone
     * @return - link
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@RequestParam(value = "Login", required = false, defaultValue = "") String login,
                          @RequestParam(value = "Password", required = false, defaultValue = "") String password,
                          @RequestParam(value = "Email", required = false, defaultValue = "") String email,
                          @RequestParam(value = "Phone", required = false, defaultValue = "") String phone,
                          Model model) {
        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(email) || StringUtils.isEmpty(phone)) {
            return "signup";
        }
        logger.info(String.format("Tries to sign up : %s : %s", login, email));
        //Validation
        if (login.matches(User.LOGIN_REGEX) && password.matches(User.PASSWORD_REGEX) && email.matches(User.EMAIL_REGEX)) {
            if (!checkUserExist(login, email, model)) {
                logger.info(String.format("Signed up: %s : %s", login, email));
                userService.signUpUser(login, password, email, phone);
                return "login";
            }
        } else {
            model.addAttribute("answer", "Введены неверные данные");
        }
        return "signup";
    }

    /**
     * Check login and email
     *
     * @param login - login
     * @param email - email
     * @return - false if they are free
     */
    private boolean checkUserExist(String login, String email, Model model) {
        if (userService.isEmailExist(email)) {
            model.addAttribute("answer", "Такой email адрес уже занят");
            logger.info(String.format("Email is exist : %s", email));
            return true;
        } else if (userService.isLoginExist(login)) {
            model.addAttribute("answer", "Такой email адрес уже занят");
            logger.info(String.format("Email is exist : %s", email));
        }
        return false;
    }
}