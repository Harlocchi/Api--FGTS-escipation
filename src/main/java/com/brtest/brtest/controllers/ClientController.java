package com.brtest.brtest.controllers;

import com.brtest.brtest.Entities.Client.Client;
import com.brtest.brtest.Entities.User.User;
import com.brtest.brtest.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public class ClientController {


    @Autowired
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients/")
    public ResponseEntity<Client> AddClient(@RequestBody Client client){
        Boolean response = clientService.AddClient(client);
        return response ?  new ResponseEntity<>(client, HttpStatus.OK): new ResponseEntity<>(client, HttpStatus.BAD_REQUEST) ;
    }


    @GetMapping("/clients/")
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @DeleteMapping("/clients/{id}/")
    public ResponseEntity<Void> DeleteClient(@PathVariable Integer id){
        Client client = clientService.getClientById(id);
        clientService.DeleteClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/clients/{id}/")
    public ResponseEntity<Client> UpdateClient(@RequestBody Client clientReq){
        clientService.updateClient(clientReq);
        return new ResponseEntity<>(clientReq, HttpStatus.OK);
    }


    @GetMapping("/clients/{id}/")
    public ResponseEntity<Optional<Client>> getClient(@PathVariable Integer id){
        Optional<Client> findclient = Optional.ofNullable(clientService.getClientById(id));
        return new ResponseEntity<>(findclient, HttpStatus.OK);
    }




}
