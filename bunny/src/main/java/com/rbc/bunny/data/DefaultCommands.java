package com.rbc.bunny.data;

import com.rbc.bunny.entities.Command;
import com.rbc.bunny.repositories.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultCommands implements ApplicationRunner {
    @Autowired
    private CommandRepository commandRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        commandRepository.save(new Command("gh", "https://github.com/", "gh <username>", "Takes you to the github profile of <username>"));
        commandRepository.save(new Command("g", "https://google.com/search?q=", "g <search-query>","performs google search for <search-query>."));
    }
}
