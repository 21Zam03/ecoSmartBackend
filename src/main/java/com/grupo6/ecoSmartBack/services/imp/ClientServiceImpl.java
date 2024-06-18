package com.grupo6.ecoSmartBack.services.imp;

import com.grupo6.ecoSmartBack.dtos.ClientDto;
import com.grupo6.ecoSmartBack.entities.ClientDocument;
import com.grupo6.ecoSmartBack.repositories.ClientRepository;
import com.grupo6.ecoSmartBack.services.ClientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDocument clientDocument) {
        ClientDocument client = clientRepository.save(clientDocument);
        ClientDto clientDto = new ClientDto();
        clientDto.setIdClient(client.getIdClient().toHexString());
        clientDto.setIdUser(client.getIdUser().toHexString());
        clientDto.setNombre(client.getNombre());
        clientDto.setApellido(client.getApellido());
        return clientDto;
    }

    @Override
    public ClientDto getClient(ObjectId idClient) {
        ClientDocument clientDocument = clientRepository.findById(idClient).get();
        ClientDto clientDto = new ClientDto();
        clientDto.setIdClient(clientDocument.getIdClient().toHexString());
        clientDto.setIdUser(clientDocument.getIdUser().toHexString());
        clientDto.setNombre(clientDocument.getNombre());
        clientDto.setApellido(clientDocument.getApellido());
        return clientDto;
    }

    @Override
    public List<ClientDto> listClient() {
        List<ClientDocument> listClientDocument = clientRepository.findAll();
        List<ClientDto> listClientDocumentDto = new ArrayList<>();
        for (int i=0; i<listClientDocument.size(); i++) {
            ClientDto clientDto = new ClientDto();
            clientDto.setIdClient(listClientDocument.get(i).getIdClient().toHexString());
            clientDto.setIdUser(listClientDocument.get(i).getIdUser().toHexString());
            clientDto.setNombre(listClientDocument.get(i).getNombre());
            clientDto.setApellido(listClientDocument.get(i).getApellido());
            listClientDocumentDto.add(clientDto);
        }
        return listClientDocumentDto;
    }

    @Override
    public ClientDto updateClient(ClientDocument client) {
        ClientDocument clientDocument = clientRepository.save(client);
        ClientDto clientDto = new ClientDto();
        clientDto.setIdClient(clientDocument.getIdClient().toHexString());
        clientDto.setIdUser(clientDocument.getIdUser().toHexString());
        clientDto.setNombre(clientDocument.getNombre());
        clientDto.setApellido(clientDocument.getApellido());
        return clientDto;
    }

    @Override
    public String deleteClient(ObjectId idClient) {
        clientRepository.deleteById(idClient);
        return "Cliente eliminado";
    }

    @Override
    public ClientDocument findByUsuarioQuery(ObjectId idUser) {
        return clientRepository.findByUsuarioQuery(idUser);
    }
}
