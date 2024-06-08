package com.grupo6.ecoSmartBack.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class UserDocument {

    @Id
    private ObjectId idUser;
    private String email;
    private String password;
    private String rol;

}
