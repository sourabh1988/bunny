package com.rbc.bunny.controllers;

import com.rbc.bunny.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public RedirectView redirectWithUsingRedirectView(@RequestParam(name = "command") String command) {
        if (command.equals("bunny help")) {
            return new RedirectView("commands");
        }

        if (command.equals("bunny add")) {
            return new RedirectView("/commands/create");
        }

        String url = searchService.getRedirectedUrl(command);
        System.out.println("url = " + url);

        return new RedirectView(url);
    }

}
