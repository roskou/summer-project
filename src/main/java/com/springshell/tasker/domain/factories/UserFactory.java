package com.springshell.tasker.domain.factories;

import com.springshell.tasker.domain.entities.StatusEntity;
import com.springshell.tasker.domain.entities.UsersEntity;
import com.springshell.tasker.domain.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public UsersEntity createEntity(UserModel userModel) {
        UsersEntity userEntity = new UsersEntity();

        userEntity.setId(userModel.getId());
        userEntity.setName(userModel.getName());
        userEntity.setLastname(userModel.getLastname());
        userEntity.setEmail(userModel.getEmail());

        return userEntity;

    }

    public UserModel createModel(UsersEntity userEntity) {
        UserModel userModel = new UserModel();

        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setLastname(userEntity.getLastname());
        userModel.setEmail(userEntity.getEmail());

        return userModel;

    }
}
