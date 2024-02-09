package com.gfa.programmerfoxclub.controllers;

import com.gfa.programmerfoxclub.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActionController {

    private ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping("/actionHistory")
    public String getActionHistory(Model model){
        model.addAttribute("actionList", actionService.getActionList());
        return "actions";
    }
}
