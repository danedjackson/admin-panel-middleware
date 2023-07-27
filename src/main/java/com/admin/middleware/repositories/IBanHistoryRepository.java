package com.admin.middleware.repositories;

import com.admin.middleware.documents.BanHistoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBanHistoryRepository extends MongoRepository<BanHistoryDocument, String> {
}
