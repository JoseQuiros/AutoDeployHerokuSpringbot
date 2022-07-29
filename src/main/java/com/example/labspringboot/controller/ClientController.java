package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Bill;
import com.example.labspringboot.domain.Client;
import com.example.labspringboot.domain.Users;
import com.example.labspringboot.service.BillService;
import com.example.labspringboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/client")
@CrossOrigin
public class ClientController {


    @Autowired
    private ClientService service;

    @GetMapping("/getAllClient")
    public List<Client> getAllClient() { return service.getAllClients();
    }
    @GetMapping("/getClient/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id){ try {
        Client client = service.getClientById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }catch(NoSuchElementException e){
        return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
    }

    }

    @PostMapping("/saveClient")
    public ResponseEntity<?> insertClient(@RequestBody Client client) { service.insertClientSP(client);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/updateClient")
    public void updateClient(@RequestBody Client client){
        service.updateClientSP(client);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id) { service.deleteClientSP(id);
    }

    /*@GetMapping("/clients")
    public List<Client> list() {
        //¿reglas de negocio?
        //if...es admin
        return service.listAll();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> get(@PathVariable Integer id) {
        try {
            Client client = service.get(id);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Client client) {
        //reglas de negocio??
        service.save(client);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Integer id) {
        try {
            service.save(client);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/

}
