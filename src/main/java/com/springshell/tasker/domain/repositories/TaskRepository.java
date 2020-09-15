package com.springshell.tasker.domain.repositories;


import com.springshell.tasker.domain.entities.TasksEntity;
import com.springshell.tasker.domain.models.TaskModel;

import java.util.List;

public interface TaskRepository {
    List<TasksEntity> findAll();
    TasksEntity findById(long id);
    void delete(TasksEntity entity);
    void insertOrUpdate(TasksEntity tasksEntity);
}
