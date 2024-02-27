package com.rbc.bunny.controllers;

import com.rbc.bunny.entities.Command;
import com.rbc.bunny.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelpController {
    @Autowired
    CommandService commandService;

    @GetMapping("/commands_no")
    public String getAllCommands(Model model) {
        List<Command> commandList = commandService.findAllCommands();
        model.addAttribute("commands", commandList);

        return "list-commands";
    }
}
