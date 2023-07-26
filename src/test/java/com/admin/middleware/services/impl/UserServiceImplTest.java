package com.admin.middleware.services.impl;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.mapping.UserMapper;
import com.admin.middleware.models.User;
import com.admin.middleware.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("User Service Implementation Tests")
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserServiceImpl userService;
    User user;
    @BeforeEach
    public void setupMocks() {
        user = new User(
                "64c094983611cc2b119007fa",
                "denise",
                "jackson",
                "denisejack",
                LocalDateTime.parse("1990-09-23T13:53:53.672"),
                true
        );
        UserDocument userDocument = new UserDocument(
                "64c094983611cc2b119007fa",
                "denise",
                "jackson",
                "denisejack",
                LocalDateTime.parse("1990-09-23T13:53:53.672"),
                LocalDateTime.parse("2023-07-26T13:28:25.983"),
                true
        );
        //Using Mockito to set up sample response data from mapper and repository
        when(userMapper.userToUserDocument(user))
                .thenReturn(userDocument);
        when(userMapper.userDocumentToUserObject(userDocument))
                .thenReturn(user);
        when(userRepository.save(userDocument))
                .thenReturn(userDocument);
    }

    @BeforeEach
    public void initializeService() {
        userService = new UserServiceImpl(userRepository, userMapper);
    }

    @Test
    @DisplayName("Testing User Service save method")
    public void defaultUserExists() {
        User expectedUser = new User(
                "64c094983611cc2b119007fa",
                "denise",
                "jackson",
                "denisejack",
                LocalDateTime.parse("1990-09-23T13:53:53.672"),
                true
        );
        //Test if user object is returned on addNewUser function call
        assertEquals(expectedUser, userService.addNewUser(expectedUser).getResponse());
    }

}