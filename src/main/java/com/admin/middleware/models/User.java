package com.admin.middleware.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String Id;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDateTime dateOfBirth;
    private Boolean isAdmin;
}
