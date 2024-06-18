package com.grupo6.ecoSmartBack.controllers;

import com.grupo6.ecoSmartBack.dtos.ClientDto;
import com.grupo6.ecoSmartBack.entities.ClientDocument;
import com.grupo6.ecoSmartBack.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClientDto createClient(@RequestBody ClientDocument clientDocument) {
        return clientService.createClient(clientDocument);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClient(@PathVariable(value = "id") ObjectId idClient) {
        return clientService.getClient(idClient);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> listClient() {
        return clientService.listClient();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteClient(@PathVariable(value = "id") ObjectId idCliente) {
        return clientService.deleteClient(idCliente);
    }

}
