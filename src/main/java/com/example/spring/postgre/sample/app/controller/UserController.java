package com.example.spring.postgre.sample.app.controller;

import com.example.spring.postgre.sample.app.entity.User;
import com.example.spring.postgre.sample.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return "Saved: "+ savedUser.getName();
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user==null)
            return "Name not found";
        return "Hello, "+ user.getName();
    }
}
