package com.admin.middleware.mappers;

import com.admin.middleware.documents.BanHistoryDocument;
import com.admin.middleware.models.UserBan;

public interface IUserBanMapper {
    BanHistoryDocument userBanToBanHistoryDocument(UserBan userBan);

    UserBan userBanHistoryDocumentToUserBan(BanHistoryDocument banHistoryDocument);
}
