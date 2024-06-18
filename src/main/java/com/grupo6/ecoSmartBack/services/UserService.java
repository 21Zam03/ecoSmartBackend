package com.grupo6.ecoSmartBack.services;

import com.grupo6.ecoSmartBack.dtos.ClientFull;
import com.grupo6.ecoSmartBack.dtos.SignUpDto;
import com.grupo6.ecoSmartBack.dtos.UserDto;
import com.grupo6.ecoSmartBack.entities.UserDocument;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDocument user);
    public UserDto getUser(ObjectId idUser);
    public List<UserDto> listUser();
    public UserDto updateUser(UserDocument user);
    public String deleteUser(ObjectId idUser);

    public ClientFull loginAction(String email, String password);
    public ClientFull signUpAction (SignUpDto signUpDto);

}
