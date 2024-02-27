package com.rbc.bunny.services;

import com.rbc.bunny.constants.BaseUrlConstants;
import com.rbc.bunny.entities.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class SearchService {
    @Autowired
    CommandService commandService;
    public String getRedirectedUrl(String queryParam) {
        int indexOfFirstSpace = queryParam.indexOf(' ');
        String cmd = "";
        String arg = "";
        if (indexOfFirstSpace == -1) {
            cmd = "g";
            arg = queryParam;
        } else {
            cmd = queryParam.substring(0, indexOfFirstSpace);
            arg = queryParam.substring(indexOfFirstSpace + 1);
        }

        return process(cmd, arg, queryParam);
    }
    public String process(String cmd, String param, String userText) {
        Optional<Command> optionalCommand = commandService.findCommandByCmd(cmd);
        return optionalCommand.map(c -> c.build(param)).orElse(BaseUrlConstants.GOOGLE_URL + userText);
    }
}
