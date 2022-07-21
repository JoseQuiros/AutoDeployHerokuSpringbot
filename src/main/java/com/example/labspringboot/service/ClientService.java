package com.example.labspringboot.service;


import com.example.labspringboot.domain.Bill;
import com.example.labspringboot.domain.Client;
import com.example.labspringboot.domain.Users;
import com.example.labspringboot.repository.BillRepository;
import com.example.labspringboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<?> getAllClients() { return repository.getAllClients();
    }

    //From the stored procedure
    public Client getClientById(int id) { return repository.getClientById(id);
    }

    //From the stored procedure
    public void insertClientSP(Client client) { repository.insertClientSP(client.getVehicle().getIdvehicle(), client.getName(),
            client.getDni(), client.getAge(), client.getTelephone(), client.getEmail(), client.getClave());
    }

    //From the stored procedure
    public void updateClientSP(Client client) { repository.updateClientSP(client.getIdclient(), client.getVehicle().getIdvehicle(), client.getName(),
            client.getDni(), client.getAge(), client.getTelephone(), client.getEmail(), client.getClave());
    }

    //From the stored procedure
    public void deleteClientSP(int id) { repository.deleteClientSP(id);
    }

    /*public List<Client> listAll() {
        return repository.findAll();
    }

    public void save(Client client) {
        repository.save(client);
    }

    public Client get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }*/

}
