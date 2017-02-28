package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contacts controller.
 */
@Controller
public class ContactsController {
    /**
     * Return link to contacts page.
     * @return - link
     */
    @RequestMapping(value = "/contacts")
    public String contactPage() {
        return "contacts";
    }
}
