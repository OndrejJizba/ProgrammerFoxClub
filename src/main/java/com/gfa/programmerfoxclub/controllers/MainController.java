package com.gfa.programmerfoxclub.controllers;

import com.gfa.programmerfoxclub.models.Fox;
import com.gfa.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private FoxService foxService;

    @Autowired
    public MainController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/")
    public String getMainPage(@RequestParam (required = false) String name, Model model){
        model.addAttribute("foxName", name);
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name){
        foxService.addFox(new Fox(name));
        Fox foundFox = foxService.findByName(name);
        return "redirect:/?name=" + foundFox.getName();
    }
}
