package com.grupo6.ecoSmartBack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFull {

    private String idClient;
    private UserDto userDto;
    private String nombre;
    private String apellido;

}
