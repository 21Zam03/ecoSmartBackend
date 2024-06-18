package com.grupo6.ecoSmartBack.controllers;

import com.grupo6.ecoSmartBack.dtos.*;
import com.grupo6.ecoSmartBack.entities.UserDocument;
import com.grupo6.ecoSmartBack.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto createUser(@RequestBody UserDocument user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable(value = "id") ObjectId idUser) {
        return userService.getUser(idUser);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> listUser() {
        return userService.listUser();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@RequestBody UserDocument userEntity) {
        return userService.updateUser(userEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable(value = "id") ObjectId idCliente) {
        return userService.deleteUser(idCliente);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientFull> login(@RequestBody LoginParameter loginParameter) {
        return ResponseEntity.ok(userService.loginAction(loginParameter.getEmail(), loginParameter.getPassword()));
    }

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientFull> signUp(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(userService.signUpAction(signUpDto));
    }

}
