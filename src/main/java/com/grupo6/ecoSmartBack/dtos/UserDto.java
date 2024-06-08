package com.grupo6.ecoSmartBack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String idUser;
    private String email;
    private String password;
    private String rol;

}
