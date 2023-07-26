package com.admin.middleware.controllers;

import com.admin.middleware.models.User;
import com.admin.middleware.services.UserService;
import com.admin.middleware.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }
}
