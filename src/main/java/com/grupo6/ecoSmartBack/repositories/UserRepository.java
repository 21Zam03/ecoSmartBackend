package com.grupo6.ecoSmartBack.repositories;

import com.grupo6.ecoSmartBack.entities.UserDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, ObjectId> {

    public UserDocument findByEmailAndPassword(String email, String password);

}
