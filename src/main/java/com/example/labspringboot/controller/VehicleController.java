package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Users;
import com.example.labspringboot.domain.Vehicle;
import com.example.labspringboot.service.UserService;
import com.example.labspringboot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(path = "/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("/getAllVehicles")
    public List<?> getAllVehicles() { return service.getAllVehicles();
    }
    @GetMapping("/getVehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
        try {
            Vehicle vehicle = service.getVehicleById(id);
            return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getVehicleByClient/{id}")
    public List<Vehicle> getVehicleByClient(@PathVariable Integer id){
        return service.getVehicleByClient(id);
    }

    @PostMapping("/saveVehicle")
    public ResponseEntity<?> insertVehicle(@RequestBody Vehicle vehicle) { service.insertVehicleSP(vehicle);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/updateVehicle")
    public void updateVehicle(@RequestBody Vehicle vehicle){ service.updateVehicleSP(vehicle);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) { service.deleteVehicleSP(id);
    }
    /*@GetMapping("/vehicles")
    public List<Vehicle> list() {
        //¿reglas de negocio?
        //if...es admin
        return service.listAll();
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> get(@PathVariable Integer id) {
        try {
            Vehicle vehicle = service.get(id);
            return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Vehicle vehicle) {
        //reglas de negocio??
        service.save(vehicle);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle, @PathVariable Integer id) {
        try {
            service.save(vehicle);
            return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/

}
