package com.grupo6.ecoSmartBack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String idClient;
    private String idUser;
    private String nombre;
    private String apellido;

}
