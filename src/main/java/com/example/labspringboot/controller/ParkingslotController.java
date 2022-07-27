package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Fee;
import com.example.labspringboot.domain.Parking;
import com.example.labspringboot.domain.Parkingslot;
import com.example.labspringboot.service.ParkingService;
import com.example.labspringboot.service.ParkingslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/parkingslot")
@CrossOrigin
public class ParkingslotController {

    @Autowired
    private ParkingslotService service;

    @GetMapping("/getAllParkingslots")
    public List<Parkingslot> getAllParkingslots() { return service.getAllParkingslots();
    }
    @GetMapping("/getParkingslot/{id}")
    public ResponseEntity<Parkingslot> getParkingslotById(@PathVariable Integer id){ try {
        Parkingslot parkingslot = service.getParkingslotById(id);
        return new ResponseEntity<Parkingslot>(parkingslot, HttpStatus.OK);
    }catch(NoSuchElementException e){
        return new ResponseEntity<Parkingslot>(HttpStatus.NOT_FOUND);
    }

    }

    @GetMapping("/getParkingslotInfo/")
    public List<?> getParkingslotInfo(@RequestBody Parkingslot parkingslot, String time){
        return service.getParkingslotInfo(parkingslot, time);
        //return new ResponseEntity<Object>(slot, HttpStatus.OK);
    }

    @GetMapping("/getSlotsbyParking/{id}")
    public List<Parkingslot> getSlotsByParking(@PathVariable Integer id){
        return service.getSlotsByParking(id);
    }

    @PostMapping("/saveParkingslot")
    public ResponseEntity<?> insertParkingslot(@RequestBody Parkingslot parkingslot) { service.insertParkingslotSP(parkingslot);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PostMapping("/updateParkingslot")
    public void updateParkingslot(@RequestBody Parkingslot parkingslot){ service.updateParkingslotSP(parkingslot);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteParkingslot(@PathVariable int id) { service.deleteParkingslotSP(id);
    }

    /*@GetMapping("/parkingslots")
    public List<Parkingslot> list() {
        //¿reglas de negocio?
        //if...es admin
        return service.listAll();
    }

    @GetMapping("/parkingslot/{id}")
    public ResponseEntity<Parkingslot> get(@PathVariable Integer id) {
        try {
            Parkingslot parkingslot = service.get(id);
            return new ResponseEntity<Parkingslot>(parkingslot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Parkingslot>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Parkingslot parkingslot) {
        //reglas de negocio??
        service.save(parkingslot);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Parkingslot> update(@RequestBody Parkingslot parkingslot, @PathVariable Integer id) {
        try {
            service.save(parkingslot);
            return new ResponseEntity<Parkingslot>(parkingslot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Parkingslot>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/

}
