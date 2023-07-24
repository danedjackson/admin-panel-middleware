package com.admin.middleware.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document("users")
@Data
public class UserDocument {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String userName;
    private LocalDateTime dateOfBirth;
    private LocalDateTime dateCreated;
    private Boolean isAdmin;

    public UserDocument(String id, String firstName, String lastName, String userName, LocalDateTime dateOfBirth, LocalDateTime dateCreated, Boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.dateCreated = dateCreated;
        this.isAdmin = isAdmin;
    }
}
