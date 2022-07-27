package com.example.labspringboot.service;


import com.example.labspringboot.domain.Users;
import com.example.labspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<Users> getAllUsers() { return repository.getAllUsers();
    }

    //From the stored procedure
    public Users getUserById(int id) { return repository.getUserById(id);
    }

    public Users logIn(String email) {
        return repository.logIn(email);
    }

    //From the stored procedure
    public void insertUserSP(Users user) { repository.insertUserSP(user.getRol().getIdrol(), user.getName(), user.getDni(), user.getAge(),
            user.getTelephone(), user.getEmail(), user.getClave());
    }

    //From the stored procedure
    public void updateUserSP(Users user) { repository.updateUserSP(user.getIduser(), user.getRol().getIdrol(), user.getName(),
            user.getDni(), user.getAge(), user.getTelephone(), user.getEmail(), user.getClave());
    }

    //From the stored procedure
    public void deleteUserSP(int id) { repository.deleteUserSP(id);
    }


    /*
    public List<Users> listAll() {
        return repository.findAll();
    }

    public void save(Users user) {
        repository.save(user);
    }

    public Users get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }*/

}
