package com.admin.middleware.mapping;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.models.User;

public interface UserMapper {
    User userDocumentToUserObject(UserDocument userDocument);

    UserDocument userToUserDocument(User user);
}
