package com.admin.middleware.services.impl;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.mapping.UserMapper;
import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.User;
import com.admin.middleware.repositories.UserRepository;
import com.admin.middleware.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ApiResponse<User> getUserById(String id) {
        Optional<UserDocument> userDocument = userRepository.findById(id);
        if(userDocument.isEmpty()) {
            return new ApiResponse<>(
                    HttpStatus.NOT_FOUND,
                    null,
                    "User with given ID was not found."
            );
        };
        User foundUser = userMapper.userDocumentToUserObject(userDocument.get());
        return new ApiResponse<>(
                HttpStatus.OK,
                foundUser,
                "User with given ID was found."
        );
    }

    @Override
    public ApiResponse<User> addNewUser(User user) {
        //Change this function return type to contain HTTP Status Code to show user already exists
        if(userRepository.findByUserName(user.getUserName()).isPresent()) {
            return new ApiResponse<>(
                    HttpStatus.ALREADY_REPORTED,
                    null,
                    "This username already exists"
            );
        }

        UserDocument userDocument = userMapper.userToUserDocument(user);
        if (userDocument.getDateCreated() == null){userDocument.setDateCreated(LocalDateTime.now());}

        User savedUser =  userMapper.userDocumentToUserObject(userRepository.save(userDocument));

        return new ApiResponse<>(
          HttpStatus.OK,
          savedUser,
          "Successfully saved user"
        );
    }
}
