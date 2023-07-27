package com.admin.middleware.controllers;

import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.User;
import com.admin.middleware.services.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService IUserService;

    public UserController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable String id) {
        return IUserService.getUserById(id);
    }

    @PostMapping("/add")
    public ApiResponse<User> addUser(@RequestBody User user) {
        return IUserService.addNewUser(user);
    }


}
