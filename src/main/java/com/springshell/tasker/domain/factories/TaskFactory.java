package com.springshell.tasker.domain.factories;


import com.springshell.tasker.domain.entities.StatusEntity;
import com.springshell.tasker.domain.entities.TasksEntity;
import com.springshell.tasker.domain.entities.UsersEntity;
import com.springshell.tasker.domain.models.StatusModel;
import com.springshell.tasker.domain.models.TaskModel;
import com.springshell.tasker.domain.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Clase que utilizamos para convertir MODELOS a ENTIDADES y viceversa
@Component
public class TaskFactory {

    private StatusFactory statusFactory;
    private UserFactory userFactory;

    @Autowired
    public TaskFactory(StatusFactory statusFactory, UserFactory userFactory) {
        this.statusFactory = statusFactory;
        this.userFactory = userFactory;
    }

    public TasksEntity createEntity(TaskModel taskModel) {

        TasksEntity tasksEntity = new TasksEntity();

        tasksEntity.setId(taskModel.getId());
        tasksEntity.setDate(taskModel.getDate());
        tasksEntity.setDescription(taskModel.getDescription());
        tasksEntity.setTitle(taskModel.getTitle());
        StatusEntity statusEntity = statusFactory.createEntity(taskModel.getStatus());
        tasksEntity.setStatusByStatusId(statusEntity);
        UsersEntity usersEntity = userFactory.createEntity(taskModel.getManager());
        tasksEntity.setUsersByUserId(usersEntity);

        return tasksEntity;

    }

    public TaskModel createModel(TasksEntity tasksEntity) {

        TaskModel taskModel = new TaskModel();

        taskModel.setId(tasksEntity.getId());
        taskModel.setDate(tasksEntity.getDate());
        taskModel.setDescription(tasksEntity.getDescription());
        taskModel.setTitle(tasksEntity.getTitle());
        StatusModel statusModel = statusFactory.createModel(tasksEntity.getStatusByStatusId());
        taskModel.setStatus(statusModel);
        UserModel userModel = userFactory.createModel(tasksEntity.getUsersByUserId());
        taskModel.setManager(userModel);

        return taskModel;

    }



}