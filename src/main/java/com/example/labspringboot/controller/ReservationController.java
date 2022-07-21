package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Reservation;
import com.example.labspringboot.domain.Rol;
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
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/reservations")
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
    }
}
