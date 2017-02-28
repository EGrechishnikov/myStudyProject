package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index controller.
 */
@Controller
public class IndexController {
    /**
     * Return link to index page.
     * @return - link
     */
    @RequestMapping("/index")
    public String welcomePage() {
        return "index";
    }
}