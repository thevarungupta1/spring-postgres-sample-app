package com.example.spring.postgre.sample.app.service;

import com.example.spring.postgre.sample.app.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User saveUser(User newUser);
}
