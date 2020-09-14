package com.springshell.tasker.domain.services;

import com.springshell.tasker.domain.entities.TaskEntity;
import com.springshell.tasker.domain.factories.TaskFactory;
import com.springshell.tasker.domain.models.TaskModel;
import com.springshell.tasker.domain.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService{
    private TaskRepository taskRepository;
    private TaskFactory taskFactory;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository, TaskFactory taskFactory) {
        this.taskRepository = taskRepository;
        this.taskFactory = taskFactory;
    }

    @Override
    public List<TaskModel> findAll() {
        List<TaskEntity> taskEntities = taskRepository.findAll();

        List<TaskModel> taskModel = new ArrayList<TaskModel>();

        for (TaskEntity tasks : taskEntities) {

            taskModel.add(taskFactory.createModel(tasks));
        }

        return taskModel;

    }

    @Override
    public TaskModel findById(long id) {
        TaskEntity taskEntity = taskRepository.findById(id);
        TaskModel taskModel = taskFactory.createModel(taskEntity);
        return taskModel;
    }

    @Override
    public void insert(TaskModel taskModel) {

    }

    @Override
    public void update(TaskModel taskModel) {

    }

    @Override
    public void delete(long id) {

    }
}
