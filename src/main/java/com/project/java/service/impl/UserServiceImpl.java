package com.project.java.service.impl;

import com.project.java.entity.UserRegister;
import com.project.java.repository.UserRepository;
import com.project.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserRegister registerUser(UserRegister user) {
        return userRepository.save(user);
    }


}
