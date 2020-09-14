package com.springshell.tasker.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tasks")
public class TaskEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String date;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity manager;

    @ManyToOne()
    @JoinColumn(name = "status_id")
    private StatusEntity status;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String title, String description, String date, UserEntity manager, StatusEntity status) {
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

    public void setDate(String createdAt) {
        this.date = createdAt;
    }

    public UserEntity getManager() {
        return manager;
    }

    public void setManager(UserEntity manager) {
        this.manager = manager;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

}
