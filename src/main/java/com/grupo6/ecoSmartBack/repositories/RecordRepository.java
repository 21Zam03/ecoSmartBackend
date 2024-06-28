package com.grupo6.ecoSmartBack.repositories;

import com.grupo6.ecoSmartBack.entities.RecordCollection;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends MongoRepository<RecordCollection, ObjectId> {

    @Query("{'clientId': ?0}")
    public List<RecordCollection> findByClientQuery(ObjectId clientID);

}
