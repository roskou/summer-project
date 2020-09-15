package com.springshell.tasker.domain.services;

import com.springshell.tasker.domain.entities.TasksEntity;
import com.springshell.tasker.domain.models.TaskModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> findAll();
    TaskModel findById(long id);
    void insertOrUpdate(TaskModel taskModel);
    void delete(TaskModel taskModel);
}
