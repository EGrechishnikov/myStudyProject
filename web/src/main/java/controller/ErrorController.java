package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Error controller.
 */
@Controller
public class ErrorController {
    /**
     * Show error page with message.
     * @param message - message
     * @return - link
     */
    @RequestMapping("/error")
    public String execute(@RequestParam(value = "message", required = false, defaultValue = "Неизвестная ошибка") String message,
                          Model model) {
        model.addAttribute("message", message);
        return "error";
    }
}
