package com.rbc.bunny.services;

import com.rbc.bunny.entities.Command;
import com.rbc.bunny.repositories.CommandRepository;
import org.hibernate.ConnectionAcquisitionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandService {
    @Autowired
    CommandRepository commandRepository;

    public Optional<Command> findCommandByCmd(String cmd) {
        return commandRepository.findById(cmd);
    }

    public List<Command> findAllCommands() {
        return commandRepository.findAll();
    }

    public Command save(Command command) {
        return commandRepository.save(command);
    }

    public void deleteByCmd(String cmd) {
        commandRepository.deleteById(cmd);
    }

    public void delete(Command command) {
        commandRepository.delete(command);
    }
}
