package controller;

import bean.User;
import filters.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.interfaces.UserServiceInterface;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EditProfileController {
    @Autowired
    private UserServiceInterface userService;

    @RequestMapping("/linkToEdit")
    public String showEdit() {
        return "editProfile";
    }

    @RequestMapping("/editProfile")
    public String editProfile(@RequestParam(value = "Login", required = false, defaultValue = "") String newLogin,
                              @RequestParam(value = "Password", required = false, defaultValue = "") String newPassword,
                              @RequestParam(value = "Email", required = false, defaultValue = "") String newEmail,
                              @RequestParam(value = "Phone", required = false, defaultValue = "") String newPhone,
                              HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        user = userService.get(user.getId());
        if (!StringUtils.isEmpty(newLogin)) {
            if (newLogin.matches(User.LOGIN_REGEX)) {
                user.setLogin(newLogin);
            }
        }
        if (!StringUtils.isEmpty(newPassword)) {
            if (newPassword.matches(User.PASSWORD_REGEX)) {
                newPassword = Hex.getHex(newPassword + user.getSalt());
                user.setPassword(newPassword);
            }
        }
        if (!StringUtils.isEmpty(newEmail)) {
            if (newEmail.matches(User.EMAIL_REGEX)) {
                user.setEmail(newEmail);
            }
        }
        if (!StringUtils.isEmpty(newPhone)) {
            user.setPhone(newPhone);
        }
        userService.saveOrUpdate(user);
        req.getSession().setAttribute("message", "Данные были успешно изменены. Выйдите и зайдите заново, " +
                "что бы изменения вступили в силу.");
        return "order";
    }
}