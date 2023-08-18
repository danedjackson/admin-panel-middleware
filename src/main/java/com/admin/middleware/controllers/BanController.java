package com.admin.middleware.controllers;

import com.admin.middleware.models.ApiResponse;
import com.admin.middleware.models.UserBan;
import com.admin.middleware.services.IBanHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/bans")
public class BanController {
    private final IBanHistoryService IBanHistoryService;
    public BanController(IBanHistoryService IBanHistoryService) {
        this.IBanHistoryService = IBanHistoryService;
    }

    @PostMapping
    public ApiResponse<UserBan> addUserBan(UserBan userBan) {
        return IBanHistoryService.addUserBan(userBan);
    }
}
