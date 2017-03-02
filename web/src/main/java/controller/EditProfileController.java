package controller;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * Edit profile controller.
 */
@Controller
public class EditProfileController {
    @Autowired
    private IUserService userService;

    /**
     * Return link to edit profile page
     * @return - link
     */
    @RequestMapping("/linkToEdit")
    public String showEdit() {
        return "editProfile";
    }

    /**
     * Get new param and send them to bd.
     * @param newLogin - new login
     * @param newPassword - new password
     * @param newEmail - new email
     * @param newPhone - new phone
     * @param session - HttpSession
     * @return - link
     */
    @RequestMapping("/editProfile")
    public String editProfile(@RequestParam(value = "Login", required = false, defaultValue = "") String newLogin,
                              @RequestParam(value = "Password", required = false, defaultValue = "") String newPassword,
                              @RequestParam(value = "Email", required = false, defaultValue = "") String newEmail,
                              @RequestParam(value = "Phone", required = false, defaultValue = "") String newPhone,
                              HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.editProfile(user.getId(), newLogin, newPassword, newEmail, newPhone);
        session.setAttribute("message", "Данные были успешно изменены. Выйдите и зайдите заново, " +
                "что бы изменения вступили в силу.");
        return "order";
    }
}
