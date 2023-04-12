package ksmart.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("title", "MainView");
        model.addAttribute("content", "complete thymeleaf layout");

        return "main";
    }
}
