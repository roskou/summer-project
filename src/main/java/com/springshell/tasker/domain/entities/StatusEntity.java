package com.springshell.tasker.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class StatusEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "status")
    private Set<TaskEntity> tasks;

    public StatusEntity() {}

    public StatusEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasks = new HashSet<TaskEntity>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<TaskEntity> getTasks() {
        return new HashSet<TaskEntity>(this.tasks);
    }
    public void setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}







