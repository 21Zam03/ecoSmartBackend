package com.grupo6.ecoSmartBack.controllers;

import com.grupo6.ecoSmartBack.dtos.RecordDto;
import com.grupo6.ecoSmartBack.entities.RecordCollection;
import com.grupo6.ecoSmartBack.services.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@Slf4j
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public RecordDto createRecord(@RequestBody RecordCollection recordCollection) {
        return recordService.createRecord(recordCollection);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecordDto> listRecords() {
        return recordService.listRecords();
    }

    @GetMapping("/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RecordDto> getRecordsByClient(@PathVariable(value = "id") ObjectId clientId) {
        return recordService.findByClientQuery(clientId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRecord(@PathVariable(value = "id") ObjectId idRecord) {
        recordService.deleteRecord(idRecord);
    }


}
