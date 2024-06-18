package com.grupo6.ecoSmartBack.repositories;

import com.grupo6.ecoSmartBack.entities.ClientDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientDocument, ObjectId> {

    @Query("{'idUser': ?0}")
    public ClientDocument findByUsuarioQuery(ObjectId idUser);

}
