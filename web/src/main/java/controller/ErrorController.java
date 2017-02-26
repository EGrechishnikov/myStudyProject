package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String execute(@RequestParam(value = "message", required = false, defaultValue = "Неизвестная ошибка") String message,
                          Model model) {
        model.addAttribute("message", message);
        return "error";
    }
}
