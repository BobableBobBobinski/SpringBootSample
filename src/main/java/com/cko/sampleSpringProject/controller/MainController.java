package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping("/")
    public String showMainPage(){
        return "MainPage";
    }
    @GetMapping("/game")
    public String showGamePage(){
        return "TicTacToe";
    }
    @GetMapping("/test")
    public String showTestPage() {
        return "Testing";
    }

}
