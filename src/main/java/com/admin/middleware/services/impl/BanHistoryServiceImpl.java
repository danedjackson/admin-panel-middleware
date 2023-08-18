package com.admin.middleware.services.impl;

import com.admin.middleware.documents.BanHistoryDocument;
import com.admin.middleware.mappers.IUserBanMapper;
import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.UserBan;
import com.admin.middleware.repositories.IBanHistoryRepository;
import com.admin.middleware.services.IBanHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BanHistoryServiceImpl implements IBanHistoryService {
    private final IBanHistoryRepository banHistoryRepository;
    private final IUserBanMapper banMapper;

    public BanHistoryServiceImpl(IBanHistoryRepository banHistoryRepository, IUserBanMapper banMapper) {
        this.banHistoryRepository = banHistoryRepository;
        this.banMapper = banMapper;
    }

    @Override
    public ApiResponse<UserBan> addUserBan(UserBan userBan) {
        if(userBan.getUserId().isEmpty()) {
            return new ApiResponse<>(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "User ID is empty, could not add ban record"
            );
        }
        BanHistoryDocument savedDocument = banHistoryRepository.save(banMapper.userBanToBanHistoryDocument(userBan));
        UserBan savedUser = banMapper.userBanHistoryDocumentToUserBan(savedDocument);

        return new ApiResponse<>(
                HttpStatus.OK,
                savedUser,
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
