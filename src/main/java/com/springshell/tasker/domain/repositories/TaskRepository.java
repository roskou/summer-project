package com.springshell.tasker.domain.repositories;


import com.springshell.tasker.domain.entities.TaskEntity;

import java.util.List;

public interface TaskRepository {
    List<TaskEntity> findAll();
    TaskEntity findById(long id);
}
