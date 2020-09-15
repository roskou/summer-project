package com.springshell.tasker;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class TaskerApplication {

    public static void main(String[] args) {
        //System.setProperty("org.jline.terminal.dumb", "true");
        ConfigurableApplicationContext context = SpringApplication.run(TaskerApplication.class, args);
    }

}