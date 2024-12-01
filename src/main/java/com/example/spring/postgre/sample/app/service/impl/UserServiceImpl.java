package com.example.spring.postgre.sample.app.service.impl;

import com.example.spring.postgre.sample.app.entity.User;
import com.example.spring.postgre.sample.app.repository.UserRepository;
import com.example.spring.postgre.sample.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }
}
