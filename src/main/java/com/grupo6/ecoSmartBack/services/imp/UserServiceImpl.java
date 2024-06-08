package com.grupo6.ecoSmartBack.services.imp;

import com.grupo6.ecoSmartBack.dtos.UserDto;
import com.grupo6.ecoSmartBack.entities.UserDocument;
import com.grupo6.ecoSmartBack.repositories.UserRepository;
import com.grupo6.ecoSmartBack.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDocument user) {
        UserDocument userDocument = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setIdUser(userDocument.getIdUser().toHexString());
        userDto.setEmail(userDocument.getEmail());
        userDto.setPassword(userDocument.getPassword());
        userDto.setRol(userDocument.getRol());
        return userDto;
    }

    @Override
    public UserDto getUser(ObjectId idUser) {
        UserDocument userDocument = userRepository.findById(idUser).get();
        UserDto userDto = new UserDto();
        userDto.setIdUser(userDocument.getIdUser().toHexString());
        userDto.setEmail(userDocument.getEmail());
        userDto.setPassword(userDocument.getPassword());
        userDto.setRol(userDocument.getRol());
        return userDto;
    }

    @Override
    public List<UserDto> listUser() {
        List<UserDocument> listUserDocument = userRepository.findAll();
        List<UserDto> listUserDocumentDto = new ArrayList<>();
        for (int i=0; i<listUserDocument.size(); i++) {
            UserDto userDto = new UserDto();
            userDto.setIdUser(listUserDocument.get(i).getIdUser().toHexString());
            userDto.setEmail(listUserDocument.get(i).getEmail());
            userDto.setPassword(listUserDocument.get(i).getPassword());
            userDto.setRol(listUserDocument.get(i).getRol());
            listUserDocumentDto.add(userDto);
        }
        return listUserDocumentDto;
    }

    @Override
    public UserDto updateUser(UserDocument user) {
        UserDocument userDocument = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setIdUser(userDocument.getIdUser().toHexString());
        userDto.setEmail(userDocument.getEmail());
        userDto.setPassword(userDocument.getPassword());
        userDto.setRol(userDocument.getRol());
        return userDto;
    }

    @Override
    public String deleteUser(ObjectId idUser) {
        userRepository.deleteById(idUser);
        return "Usuario eliminado";
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        UserDocument userDocument = userRepository.findByEmailAndPassword(email, password);
        UserDto userDto = new UserDto();
        userDto.setIdUser(userDocument.getIdUser().toHexString());
        userDto.setEmail(userDocument.getEmail());
        userDto.setPassword(userDocument.getPassword());
        userDto.setRol(userDocument.getRol());
        return userDto;
    }

}
