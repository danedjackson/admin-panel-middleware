package com.admin.middleware.services.impl;

import com.admin.middleware.documents.BanHistoryDocument;
import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.repositories.IBanHistoryRepository;
import com.admin.middleware.services.IBanHistoryService;
import org.springframework.http.HttpStatus;

public class BanHistoryServiceImpl implements IBanHistoryService {
    private final IBanHistoryRepository banHistoryRepository;

    public BanHistoryServiceImpl(IBanHistoryRepository banHistoryRepository) {
        this.banHistoryRepository = banHistoryRepository;
    }

    @Override
    public ApiResponse<BanHistoryDocument> addUserBan(BanHistoryDocument banHistoryDocument) {
        if(banHistoryDocument.getUserId().isEmpty()) {
            return new ApiResponse<>(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "User ID is empty, could not add ban record"
            );
        }

        BanHistoryDocument savedDocument = banHistoryRepository.save(banHistoryDocument);

        return new ApiResponse<>(
                HttpStatus.OK,
                savedDocument,
                "Successfully saved ban record"
        );
    }

    @Override
    public ApiResponse<BanHistoryDocument> checkUserBan(String userId) {
        return null;
    }

    @Override
    public ApiResponse<BanHistoryDocument> removeUserBan(String banId) {
        return null;
    }
}
