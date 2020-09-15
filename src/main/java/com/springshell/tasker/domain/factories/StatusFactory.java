package com.springshell.tasker.domain.factories;

import com.springshell.tasker.domain.entities.StatusEntity;
import com.springshell.tasker.domain.models.StatusModel;
import org.springframework.stereotype.Component;

@Component
public class StatusFactory {
    public StatusEntity createEntity(StatusModel statusModel) {
        StatusEntity statusEntity = new StatusEntity();

        statusEntity.setId(statusModel.getId());
        statusEntity.setName(statusModel.getName());
        statusEntity.setDescription(statusModel.getDescription());

        return statusEntity;

    }

    public StatusModel createModel(StatusEntity statusEntity) {
        StatusModel statusModel = new StatusModel();

        statusModel.setId(statusEntity.getId());
        statusModel.setName(statusEntity.getName());
        statusModel.setDescription(statusEntity.getDescription());

        return statusModel;

    }
}
