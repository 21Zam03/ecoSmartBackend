package com.grupo6.ecoSmartBack.services;

import com.grupo6.ecoSmartBack.dtos.RecordDto;
import com.grupo6.ecoSmartBack.entities.RecordCollection;
import org.bson.types.ObjectId;

import java.util.List;

public interface RecordService {
    public RecordDto createRecord(RecordCollection recordCollection);
    public List<RecordDto> findByClientQuery(ObjectId clientID);
    public void deleteRecord(ObjectId recordId);
    public List<RecordDto> listRecords();
}
