package com.springshell.tasker.domain.services;

import com.springshell.tasker.domain.entities.TasksEntity;
import com.springshell.tasker.domain.factories.TaskFactory;
import com.springshell.tasker.domain.models.TaskModel;
import com.springshell.tasker.domain.repositories.TaskRepository;
import com.springshell.tasker.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    private TaskRepository taskRepository;
    private TaskFactory taskFactory;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository, TaskFactory taskFactory) {
        this.taskRepository = taskRepository;
        this.taskFactory = taskFactory;
    }

    @Override
    public List<TaskModel> findAll() {
        List<TasksEntity> taskEntities = taskRepository.findAll();

        List<TaskModel> taskModel = new ArrayList<TaskModel>();

        for (TasksEntity tasks : taskEntities) {

            taskModel.add(taskFactory.createModel(tasks));
        }

        return taskModel;

    }

    @Override
    public TaskModel findById(long id) {
        TasksEntity tasksEntity = taskRepository.findById(id);
        TaskModel taskModel = taskFactory.createModel(tasksEntity);
        return taskModel;
    }

    @Override
    public void insertOrUpdate(TaskModel taskModel) {
        TasksEntity tasksEntity = taskFactory.createEntity(taskModel);
        taskRepository.insertOrUpdate(tasksEntity);

    }



    @Override
    public void delete(TaskModel model) {
        TasksEntity taskEntity = taskRepository.findById(model.getId());
        taskRepository.delete(taskEntity);
    }
}
