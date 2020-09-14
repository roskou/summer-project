package com.springshell.tasker.domain.factories;

import com.springshell.tasker.domain.entities.StatusEntity;
import com.springshell.tasker.domain.entities.UserEntity;
import com.springshell.tasker.domain.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public UserEntity createEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userModel.getId());
        userEntity.setName(userModel.getName());
        userEntity.setLastname(userModel.getLastname());
        userEntity.setEmail(userModel.getEmail());

        return userEntity;

    }

    public UserModel createModel(UserEntity userEntity) {
        UserModel userModel = new UserModel();

        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setLastname(userEntity.getLastname());
        userModel.setEmail(userEntity.getEmail());

        return userModel;

    }
}
