package com.admin.middleware.mappers;

import com.admin.middleware.documents.UserDocument;
import com.admin.middleware.models.User;

public interface IUserMapper {
    User userDocumentToUserObject(UserDocument userDocument);

    UserDocument userToUserDocument(User user);
}
