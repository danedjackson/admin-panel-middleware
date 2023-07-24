package com.admin.middleware.repositories;

import com.admin.middleware.documents.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {
    //Custom query annotation which takes the parameter id as search criteria (?0)
    @Query("{id:'?0'}")
    Optional<UserDocument> findById(String id);

    List<UserDocument> findAll();
}
