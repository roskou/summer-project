package com.springshell.tasker.ui.command;

import com.springshell.tasker.domain.models.StatusModel;
import com.springshell.tasker.domain.models.TaskModel;
import com.springshell.tasker.domain.models.UserModel;
import com.springshell.tasker.domain.services.TaskService;
import com.springshell.tasker.ui.shell.ShellHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.Timestamp;
import java.util.List;

@ShellComponent
public class EchoCommand {

    @Autowired
    ShellHelper shellHelper;

    @Autowired
    TaskService taskService;


    @ShellMethod("lista todas las tareas")
    public void listar() {
        String output = "";
        List<TaskModel> tasks = taskService.findAll();

        if (tasks.size() != 0) {
            shellHelper.printSuccess("\n");
            for (int i = 0; i < tasks.size(); i++) {
                output = i + ")" + tasks.get(i);
                shellHelper.printInfo(output);
            }
            shellHelper.printSuccess("\nTodos los datos listados.\n");
        }else{
            shellHelper.printWarning("\nNo existen Tareas\n");
        }

        return ;

    }

    @ShellMethod("Elimina una Tarea creada")
    public void eliminar(@ShellOption({"-E", "--eleccion"}) int eleccion) {
        List<TaskModel> tasks = taskService.findAll();
        taskService.delete(tasks.get(eleccion));
        shellHelper.printInfo("\nTarea numero " + eleccion + " eliminada. (" + tasks.get(eleccion).getTitle() + ")\n");
        return;
    }
    @ShellMethod("Inserta una nueva Tarea")
    public void insertar() {
        //shellHelper.printError("\n COMANDO NO IMPLEMENTADO !!\n");
        TaskModel taskmodel = new TaskModel(new UserModel("pepito", "perez", "dsd@df.com"),new StatusModel("a","b"),"Limpiar la clase","hasdgajhsdfgjasfd", "2020-10-1 00:00");
        try {
            taskService.insertOrUpdate(taskmodel);

shellHelper.printWarning("·TAREA INSERTADA");
        }catch(Exception e){
            shellHelper.printError("BOOM!");
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getLocalizedMessage());
        }
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