package com.admin.middleware.services;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.User;

import java.time.LocalDateTime;

public interface UserService {
    ApiResponse<User> getUserById(String id);
    ApiResponse<User> addNewUser(User user);
}
