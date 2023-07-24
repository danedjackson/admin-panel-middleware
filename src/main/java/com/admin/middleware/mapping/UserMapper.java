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

        return user;
    }
}
