package com.speedy.food.services;

import com.speedy.food.model.User;
import com.speedy.food.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {
}
