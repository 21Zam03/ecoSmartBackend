package com.grupo6.ecoSmartBack.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "records")
public class RecordCollection {

    @Id
    private ObjectId recordId;
    private ObjectId clientId;
    private Double kwh;
    private Double cost;

}
