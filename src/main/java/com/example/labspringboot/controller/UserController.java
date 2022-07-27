package com.example.labspringboot.controller;


import com.example.labspringboot.domain.Users;
import com.example.labspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() { return service.getAllUsers();
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<Users> logIn(@PathVariable String email){ try {
        Users user = service.logIn(email);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }catch(NoSuchElementException e){
        return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
    }

    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id){ try {
        Users user = service.getUserById(id);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }catch(NoSuchElementException e){
        return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
    }

    }
    @PostMapping("/saveUser")
    public ResponseEntity<?> insertUser(@RequestBody Users user) { service.insertUserSP(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/updateUser")
    public void updateUser(@RequestBody Users user){
        service.updateUserSP(user);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) { service.deleteUserSP(id);
    }

    /*@GetMapping("/users")
    public List<Users> list() {
        //¿reglas de negocio?
        //if...es admin
        return service.listAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> get(@PathVariable Integer id) {
        try {
            Users user = service.get(id);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Users user) {
        //reglas de negocio??
        service.save(user);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Users> update(@RequestBody Users user, @PathVariable Integer id) {
        try {
            service.save(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/
}
