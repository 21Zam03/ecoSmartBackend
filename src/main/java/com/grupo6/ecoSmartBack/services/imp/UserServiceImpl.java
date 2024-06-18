package com.grupo6.ecoSmartBack.services.imp;

import com.grupo6.ecoSmartBack.dtos.ClientDto;
import com.grupo6.ecoSmartBack.dtos.ClientFull;
import com.grupo6.ecoSmartBack.dtos.SignUpDto;
import com.grupo6.ecoSmartBack.dtos.UserDto;
import com.grupo6.ecoSmartBack.entities.ClientDocument;
import com.grupo6.ecoSmartBack.entities.UserDocument;
import com.grupo6.ecoSmartBack.repositories.ClientRepository;
import com.grupo6.ecoSmartBack.repositories.UserRepository;
import com.grupo6.ecoSmartBack.services.ClientService;
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

    @Autowired
    private ClientService clientService;

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
        for (UserDocument userDocument : listUserDocument) {
            UserDto userDto = new UserDto();
            userDto.setIdUser(userDocument.getIdUser().toHexString());
            userDto.setEmail(userDocument.getEmail());
            userDto.setPassword(userDocument.getPassword());
            userDto.setRol(userDocument.getRol());
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
    public ClientFull loginAction(String email, String password) {
        UserDocument userDocument = userRepository.findByEmailAndPassword(email, password);
        UserDto userDto = new UserDto();
        userDto.setIdUser(userDocument.getIdUser().toHexString());
        userDto.setEmail(userDocument.getEmail());
        userDto.setPassword(userDocument.getPassword());
        userDto.setRol(userDocument.getRol());
        ClientDocument clientDocument = clientService.findByUsuarioQuery(userDocument.getIdUser());
        ClientFull clientFull = new ClientFull();
        clientFull.setIdClient(clientDocument.getIdClient().toHexString());
        clientFull.setUserDto(this.getUser(clientDocument.getIdUser()));
        clientFull.setNombre(clientDocument.getNombre());
        clientFull.setApellido(clientDocument.getApellido());
        return clientFull;
    }

    @Override
    public ClientFull signUpAction(SignUpDto signUpDto) {
        UserDocument userDocument = signUpDto.getUserDocument();
        UserDto userDto = this.createUser(userDocument);

        ClientDocument clientDocument = signUpDto.getClientDocument();
        clientDocument.setIdUser(new ObjectId(userDto.getIdUser()));
        ClientDto clientDto = clientService.createClient(clientDocument);

        ClientFull clientFull = new ClientFull();
        clientFull.setIdClient(clientDto.getIdClient());
        clientFull.setUserDto(userDto);
        clientFull.setNombre(clientDto.getNombre());
        clientFull.setApellido(clientDto.getApellido());

        return clientFull;
    }

}
