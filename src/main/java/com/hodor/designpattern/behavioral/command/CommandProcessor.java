package com.hodor.designpattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {

    List<Command> commands = new ArrayList<>();


    public CommandProcessor addCommand(Command command) {
        commands.add(command);
        return this;
    }

    public void processCommand() {
        for(Command command: commands) {
            command.execute();
        }
    }
}
