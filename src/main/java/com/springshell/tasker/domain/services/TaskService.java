package com.springshell.tasker.domain.services;

import com.springshell.tasker.domain.models.TaskModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> findAll();
    TaskModel findById(long id);
    void insert(TaskModel taskModel);
    void update(TaskModel taskModel);
    void delete(long id);
}
