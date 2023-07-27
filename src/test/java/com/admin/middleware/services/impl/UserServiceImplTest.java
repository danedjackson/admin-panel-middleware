package com.admin.middleware.services.impl;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.mappers.IUserMapper;
import com.admin.middleware.models.User;
import com.admin.middleware.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("User Service Implementation Tests")
class UserServiceImplTest {
    @Mock
    IUserRepository IUserRepository;
    @Mock
    IUserMapper IUserMapper;
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
        when(IUserMapper.userToUserDocument(user))
                .thenReturn(userDocument);
        when(IUserMapper.userDocumentToUserObject(userDocument))
                .thenReturn(user);
        when(IUserRepository.save(userDocument))
                .thenReturn(userDocument);

        userService = new UserServiceImpl(IUserRepository, IUserMapper);
    }

    @Test
    @DisplayName("Testing User Service save method")
    public void testAddNewUser_Success() {
        //Given
        User expectedUser = new User(
                "64c094983611cc2b119007fa",
                "denise",
                "jackson",
                "denisejack",
                LocalDateTime.parse("1990-09-23T13:53:53.672"),
                true
        );
        // When
        User resultUser = userService.addNewUser(expectedUser).getResponse();

        // Then
        assertEquals(expectedUser, resultUser);
        verify(IUserRepository).save(any(UserDocument.class));
    }

    @Test
    @Disabled("Temporarily disabled for refining")
    @DisplayName("Testing User Service get method")
    public void testGetUser_Success() {
        //Given
        User expectedUser = new User(
                "64c094983611cc2b119007fa",
                "denise",
                "jackson",
                "denisejack",
                LocalDateTime.parse("1990-09-23T13:53:53.672"),
                true
        );

        //When
        User actualUser = userService.getUserById(expectedUser.getId()).getResponse();

        //Then
        assertEquals(expectedUser, actualUser);
    }
}