package com.springshell.tasker.ui.command;

import com.springshell.tasker.domain.services.TaskService;
import com.springshell.tasker.ui.shell.ShellHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class EchoCommand {

    @Autowired
    ShellHelper shellHelper;

    @Autowired
    TaskService taskService;

    @ShellMethod("Bienvenido al gestor de tareas de SEAT:CODE")
    public String echo(@ShellOption({"-N", "--name"}) String name) {
        String output = shellHelper.getSuccessMessage(String.format("Hola %s!", name));
        return output.concat(" You are running spring shell cli-demo.");

    }

    @ShellMethod("Bienvenido al gestor de tareas de SEAT:CODE")
    public String oscar() {
        return taskService.findAll().toString();
        //return

    }

    @ShellMethod("Test")
    public String saludo(@ShellOption({"-N", "--name"}) String name) {
        String message = String.format("Hello %s!", name);
        shellHelper.print(message.concat(" (Default style message)"));
        shellHelper.printError(message.concat(" (Error style message)"));
        shellHelper.printWarning(message.concat(" (Warning style message)"));
        shellHelper.printInfo(message.concat(" (Info style message)"));
        shellHelper.printSuccess(message.concat(" (Success style message)"));

        String output = shellHelper.getSuccessMessage(message);
        return output.concat(" You are running spring shell cli-demo.");
    }

}