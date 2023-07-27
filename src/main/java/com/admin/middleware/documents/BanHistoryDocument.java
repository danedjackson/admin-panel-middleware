package com.admin.middleware.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("banhistory")
@Data
@AllArgsConstructor
public class BanHistoryDocument {
    @Id
    private String id;

    private String userId;
    private LocalDateTime dateOfBan;
    private String banReason;
    private String banComment;
    private Integer banDurationHours;
}
