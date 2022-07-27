package com.example.labspringboot.service;

import com.example.labspringboot.domain.Rol;
import com.example.labspringboot.domain.Users;
import com.example.labspringboot.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RolService {

    @Autowired
    private RolRepository repository;

    public List<Rol> getAllRoles() { return repository.getAllRoles();
    }

    //From the stored procedure
    public Rol getRolById(int id) { return repository.getRol(id);
    }

    //From the stored procedure
    public void insertRol(Rol rol) { repository.insertRol(rol.getName(), rol.getAuthority());
    }

    //From the stored procedure
    public void updateRol(Rol rol) { repository.updateRol(rol.getIdrol(), rol.getAuthority());
    }

    //From the stored procedure
    public void deleteRol(int id) { repository.deleteRol(id);
    }

    /*
    public List<Rol> listAll() {
        return repository.findAll();
    }

    public void save(Rol rol) {
        repository.save(rol);
    }

    public Rol get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }*/

}
