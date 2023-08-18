package com.admin.middleware.mappers.impl;

import com.admin.middleware.documents.BanHistoryDocument;
import com.admin.middleware.mappers.IUserBanMapper;
import com.admin.middleware.models.UserBan;

public class UserBanMapperImpl implements IUserBanMapper {
    @Override
    public BanHistoryDocument userBanToBanHistoryDocument(UserBan userBan) {
        //Do mappings here when needed
        return new BanHistoryDocument(
                null,
                userBan.getUserId(),
                userBan.getDateOfBan(),
                userBan.getBannedBy(),
                userBan.getBanReason(),
                userBan.getBanComment(),
                userBan.getBanDurationHours()
        );
    }

    @Override
    public UserBan userBanHistoryDocumentToUserBan(BanHistoryDocument banHistoryDocument) {
        //Do mappings here when needed
        return new UserBan(
                banHistoryDocument.getUserId(),
                banHistoryDocument.getDateOfBan(),
                banHistoryDocument.getBanReason(),
                banHistoryDocument.getBannedBy(),
                banHistoryDocument.getBanComment(),
                banHistoryDocument.getBanDurationHours()
        );
    }
}
