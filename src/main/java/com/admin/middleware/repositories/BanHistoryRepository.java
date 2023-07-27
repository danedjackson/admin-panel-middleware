package com.admin.middleware.repositories;

import com.admin.middleware.documents.BanHistoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BanHistoryRepository extends MongoRepository<BanHistoryDocument, String> {
}
