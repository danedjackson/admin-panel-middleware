package com.admin.middleware.services;

import com.admin.middleware.documents.BanHistoryDocument;
import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.UserBan;
import org.springframework.stereotype.Service;

@Service
public interface IBanHistoryService {

    ApiResponse<UserBan> addUserBan(UserBan UserBan);
    ApiResponse<BanHistoryDocument> checkUserBan(String userId);
    ApiResponse<BanHistoryDocument> removeUserBan(String banId);
}
