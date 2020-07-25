package com.speedy.food.resources;

import com.speedy.food.dto.user.InputUserDto;
import com.speedy.food.dto.user.OutputUserDto;
import com.speedy.food.mappers.UserMapper;
import com.speedy.food.model.User;
import com.speedy.food.repository.UserRepository;
import com.speedy.food.services.UserService;

public class UserResource extends AbstractResource<User, UserRepository, InputUserDto,
        OutputUserDto, UserMapper, UserService> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
