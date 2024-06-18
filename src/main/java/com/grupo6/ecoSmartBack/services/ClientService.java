package com.grupo6.ecoSmartBack.services;

import com.grupo6.ecoSmartBack.dtos.ClientDto;
import com.grupo6.ecoSmartBack.entities.ClientDocument;
import org.bson.types.ObjectId;

import java.util.List;

public interface ClientService {

    public ClientDto createClient(ClientDocument clientDocument);
    public ClientDto getClient(ObjectId idClient);
    public List<ClientDto> listClient();
    public ClientDto updateClient(ClientDocument client);
    public String deleteClient(ObjectId idClient);

    public ClientDocument findByUsuarioQuery(ObjectId idUser);
}
