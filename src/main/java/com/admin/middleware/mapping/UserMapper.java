package com.admin.middleware.mapping;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userDocumentToUserObject(UserDocument userDocument) {
        if (userDocument.getId() == null) return new User();

        User user = new User();
        user.setId(userDocument.getId());
        user.setUserName(userDocument.getUserName());
        user.setFirstName(userDocument.getFirstName());
        user.setLastName(userDocument.getLastName());
        user.setDateOfBirth(userDocument.getDateOfBirth());
        user.setIsAdmin(userDocument.getIsAdmin());

        return user;
    }

    public UserDocument userToUserDocument(User user) {

        return new UserDocument(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getDateOfBirth(),
                null,
                user.getIsAdmin()
                );
    }
}
