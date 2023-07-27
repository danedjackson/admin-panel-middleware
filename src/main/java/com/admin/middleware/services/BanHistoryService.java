package com.admin.middleware.services;

import com.admin.middleware.documents.BanHistoryDocument;
import com.admin.middleware.models.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface BanHistoryService {

    ApiResponse<BanHistoryDocument> addUserBan(BanHistoryDocument banHistoryDocument);
    ApiResponse<BanHistoryDocument> checkUserBan(String userId);
    ApiResponse<BanHistoryDocument> removeUserBan(String banId);
}
