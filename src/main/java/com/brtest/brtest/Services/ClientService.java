package com.brtest.brtest.Services;

import com.brtest.brtest.Entities.Client.Client;
import com.brtest.brtest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    public ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(int Id){
        return clientRepository.findById(Id).orElse(null);
    }

    public Boolean DeleteClient(Client client){
        clientRepository.deleteById(client.getId());
        return true;
    }

    public Boolean updateClient(Client client){
        clientRepository.saveAndFlush(client);
        return true;
    }

    public Boolean AddClient(Client client) {
        clientRepository.saveAndFlush(client);
        return true;
    }





}
