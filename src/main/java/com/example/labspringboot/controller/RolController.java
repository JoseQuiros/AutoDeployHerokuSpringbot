package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Fee;
import com.example.labspringboot.domain.Rol;
import com.example.labspringboot.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/rol")
@CrossOrigin
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping("/getAllRoles")
    public List<Rol> getAllRoles() { return service.getAllRoles();
    }
    @GetMapping("/getRol/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id){ try {
        Rol rol = service.getRolById(id);
        return new ResponseEntity<Rol>(rol, HttpStatus.OK);
    }catch(NoSuchElementException e){
        return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
    }

    }

    @PostMapping("/saveRol")
    public ResponseEntity<?> insertRol(@RequestBody Rol rol) { service.insertRol(rol);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/updateRol")
    public void updateRol(@RequestBody Rol rol){ service.updateRol(rol);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRol(@PathVariable int id) { service.deleteRol(id);
    }

    /*@GetMapping("/roles")
    public List<Rol> list() {
        //¿reglas de negocio?
        //if...es admin
        
        return service.listAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Rol> get(@PathVariable Integer id) {
        try {
            Rol rol = service.get(id);
            return new ResponseEntity<Rol>(rol, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Rol rol) {
        //reglas de negocio??
        service.save(rol);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> update(@RequestBody Rol rol, @PathVariable Integer id) {
        try {
            service.save(rol);
            return new ResponseEntity<Rol>(rol, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/

}
