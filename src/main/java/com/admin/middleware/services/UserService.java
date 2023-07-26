package com.admin.middleware.services;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.models.User;

import java.time.LocalDateTime;

public interface UserService {
    User getUserById(String id);
    User addNewUser(User user);
}
