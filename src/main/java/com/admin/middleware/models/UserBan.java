package com.admin.middleware.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserBan {

    private String userId;
    private LocalDateTime dateOfBan;
    private String banReason;
    private String bannedBy;
    private String banComment;
    private Integer banDurationHours;

}
