package com.admin.middleware.controllers;

import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.User;
import com.admin.middleware.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ApiResponse<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/add")
    public ApiResponse<User> addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }


}
