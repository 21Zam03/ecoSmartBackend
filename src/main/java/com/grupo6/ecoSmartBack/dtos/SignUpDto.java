package com.grupo6.ecoSmartBack.dtos;

import com.grupo6.ecoSmartBack.entities.ClientDocument;
import com.grupo6.ecoSmartBack.entities.UserDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    private ClientDocument clientDocument;
    private UserDocument userDocument;

}
