package com.grupo6.ecoSmartBack.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDocument {

    @Id
    private ObjectId idClient;
    private ObjectId idUser;
    private String nombre;
    private String apellido;

}
