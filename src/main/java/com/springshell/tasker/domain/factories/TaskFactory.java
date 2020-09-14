package com.springshell.tasker.domain.factories;


import com.springshell.tasker.domain.entities.StatusEntity;
import com.springshell.tasker.domain.entities.TaskEntity;
import com.springshell.tasker.domain.entities.UserEntity;
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

    public TaskEntity createEntity(TaskModel taskModel) {

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId(taskModel.getId());
        taskEntity.setDate(taskModel.getDate());
        taskEntity.setDescription(taskModel.getDescription());
        taskEntity.setTitle(taskModel.getTitle());
        StatusEntity statusEntity = statusFactory.createEntity(taskModel.getStatus());
        taskEntity.setStatus(statusEntity);
        UserEntity userEntity = userFactory.createEntity(taskModel.getManager());
        taskEntity.setManager(userEntity);

        return taskEntity;

    }

    public TaskModel createModel(TaskEntity taskEntity) {

        TaskModel taskModel = new TaskModel();

        taskModel.setId(taskEntity.getId());
        taskModel.setDate(taskEntity.getDate());
        taskModel.setDescription(taskEntity.getDescription());
        taskModel.setTitle(taskEntity.getTitle());
        StatusModel statusModel = statusFactory.createModel(taskEntity.getStatus());
        taskModel.setStatus(statusModel);
        UserModel userModel = userFactory.createModel(taskEntity.getManager());
        taskModel.setManager(userModel);

        return taskModel;

    }



}