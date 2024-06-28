package com.grupo6.ecoSmartBack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDto {

    private String recordId;
    private String clientId;
    private Double kwh;
    private Double cost;

}
