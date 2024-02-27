package com.rbc.bunny.controllers;

import com.rbc.bunny.entities.Command;
import com.rbc.bunny.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/commands")
public class CommandController {
    @Autowired
    CommandService commandService;

    @PostMapping("/create")
    public String addCommand(@ModelAttribute Command command) {
        commandService.save(command);
        return "redirect:/commands";
    }

    @GetMapping
    public String listCommands(Model model) {
        List<Command> commands = commandService.findAllCommands();
        model.addAttribute("commands", commands);
        return "commands/list";
    }

    @GetMapping("/edit/{cmd}")
    public String editItemForm(@PathVariable String cmd, Model model) {
        Command command = commandService.findCommandByCmd(cmd)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Command id: " + cmd));
        model.addAttribute("command", command);
        return "commands/edit";
    }

    @PostMapping("/edit/{cmd}")
    public String editItem(@PathVariable String cmd, @ModelAttribute Command command) {
        command.setCmd(cmd);
        commandService.save(command);
        return "redirect:/commands";
    }


    @GetMapping("/create")
    public String createCommandForm(Model model) {
        model.addAttribute("command", new Command());
        return "commands/create";
    }

    @DeleteMapping("/command/{cmd}")
    public void deleteCommand(@PathVariable("cmd") String commandStr) {
        commandService.deleteByCmd(commandStr);
    }
}
