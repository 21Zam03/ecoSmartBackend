package com.grupo6.ecoSmartBack.services.imp;

import com.grupo6.ecoSmartBack.dtos.RecordDto;
import com.grupo6.ecoSmartBack.entities.RecordCollection;
import com.grupo6.ecoSmartBack.repositories.RecordRepository;
import com.grupo6.ecoSmartBack.services.RecordService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public RecordDto createRecord(RecordCollection recordCollection) {
        RecordCollection recordCollectiont1 = recordRepository.save(recordCollection);
        RecordDto recordDto = new RecordDto();
        recordDto.setRecordId(recordCollectiont1.getRecordId().toHexString());
        recordDto.setClientId(recordCollectiont1.getClientId().toHexString());
        recordDto.setKwh(recordCollectiont1.getKwh());
        recordDto.setCost(recordCollectiont1.getCost());
        return recordDto;
    }

    @Override
    public List<RecordDto> findByClientQuery(ObjectId clientID) {
        List<RecordCollection> recordList = recordRepository.findByClientQuery(clientID);
        List<RecordDto> recordDtoList = new ArrayList<>();
        for (RecordCollection recordCollection : recordList) {
            RecordDto recordDto = new RecordDto();
            recordDto.setRecordId(recordCollection.getRecordId().toHexString());
            recordDto.setClientId(recordCollection.getClientId().toHexString());
            recordDto.setKwh(recordCollection.getKwh());
            recordDto.setCost(recordCollection.getCost());
            recordDtoList.add(recordDto);
        }
        return recordDtoList;
    }

    @Override
    public void deleteRecord(ObjectId recordId) {
        recordRepository.deleteById(recordId);
    }

    @Override
    public List<RecordDto> listRecords() {
        List<RecordCollection> recordList = recordRepository.findAll();
        List<RecordDto> recordDtoList = new ArrayList<>();
        for (RecordCollection recordCollection : recordList) {
            RecordDto recordDto = new RecordDto();
            recordDto.setRecordId(recordCollection.getRecordId().toHexString());
            recordDto.setClientId(recordCollection.getClientId().toHexString());
            recordDto.setKwh(recordCollection.getKwh());
            recordDto.setCost(recordCollection.getCost());
            recordDtoList.add(recordDto);
        }
        return recordDtoList;
    }
}
