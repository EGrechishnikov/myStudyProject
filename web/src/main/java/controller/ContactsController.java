package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactsController {
    @RequestMapping(value = "/contacts")
    public String contactPage() {
        return "contacts";
    }
}
