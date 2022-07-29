package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Reservation;
import com.example.labspringboot.domain.Rol;
import com.example.labspringboot.domain.Vehicle;
import com.example.labspringboot.service.ReservationService;
import com.example.labspringboot.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/getAllReservations")
    public List<?> getAllReservations() { return service.getAllReservations();
    }
    @GetMapping("/getAllReservationsByClient/{id}")
    public List<?> getAllReservationsByClient(@PathVariable Integer id){
        return service.getAllReservationsByClient(id);
    }

    @GetMapping("/getReservation/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Integer id){ try {
        Object reservation = new Object();
        reservation = service.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }catch(NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }

    @PostMapping("/consultCost")
    public Object consultCost(@RequestBody Reservation reservation) {
        Object consult = new Object();
        return consult = service.consultCostSP(reservation);
        //return new ResponseEntity<>(consult, HttpStatus.OK);
    }

    @PostMapping("/saveReservation")
    public ResponseEntity<?> insertReservation(@RequestBody Reservation reservation) { service.insertReservationSP(reservation);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/cancel/{id}")
    public void cancelReservation(@PathVariable int id) { service.cancelReservationSP(id);
    }

    /*@GetMapping("/reservations")
    public List<Reservation> list() {
        //¿reglas de negocio?
        //if...es admin
        return service.listAll();
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Integer id) {
        try {
            Reservation reservation = service.get(id);
            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Reservation reservation) {
        //reglas de negocio??
        service.save(reservation);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> update(@RequestBody Reservation reservation, @PathVariable Integer id) {
        try {
            service.save(reservation);

            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }*/
}
