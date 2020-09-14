package com.springshell.tasker.domain.models;


public class TaskModel {
    private Long id;
    private UserModel manager;
    private StatusModel status;
    private String title;
    private String description;
    private String date;

    public TaskModel(){};

    public TaskModel(Long id, UserModel manager, StatusModel status, String title, String description, String date) {
        this.id = id;
        this.manager = manager;
        this.status = status;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserModel getManager() {
        return manager;
    }

    public void setManager(UserModel manager) {
        this.manager = manager;
    }

    public StatusModel getStatus() {
        return status;
    }

    public void setStatus(StatusModel status) {
        this.status = status;
    }
}
