package com.admin.middleware.services.impl;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.mapping.UserMapper;
import com.admin.middleware.models.User;
import com.admin.middleware.repositories.UserRepository;
import com.admin.middleware.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getUserById(String id) {
        Optional<UserDocument> userDocument = userRepository.findById(id);
        if(userDocument.isEmpty()) return new User();
        return userMapper.userDocumentToUserObject(userDocument.get());
    }
}
