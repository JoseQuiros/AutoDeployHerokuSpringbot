package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Bill;
import com.example.labspringboot.domain.Rol;
import com.example.labspringboot.service.BillService;
import com.example.labspringboot.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/bill")
public class BillController {

    @Autowired
    private BillService service;

    @GetMapping("/getAllBills")
    public List<Bill> getAllBills() { return service.getAllBills();
    }

    @PostMapping("/insertBill/{id}")
    public ResponseEntity<?> insertBill(@RequestBody Bill bill, @PathVariable Integer id) { service.insertBillSP(id, bill);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    /*
    @GetMapping("/bills")
    public List<Bill> list() {
        //¿reglas de negocio?
        //if...es admin
        return service.listAll();
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<Bill> get(@PathVariable Integer id) {
        try {
            Bill bill = service.get(id);
            return new ResponseEntity<Bill>(bill, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(Bill bill) {
        //reglas de negocio??
        service.save(bill);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bill> update(@RequestBody Bill bill, @PathVariable Integer id) {
        try {
            service.save(bill);
            return new ResponseEntity<Bill>(bill, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    */

}
