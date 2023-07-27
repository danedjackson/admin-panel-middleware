package com.admin.middleware.services;

import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.User;

public interface IUserService {
    ApiResponse<User> getUserById(String id);
    ApiResponse<User> addNewUser(User user);
}
