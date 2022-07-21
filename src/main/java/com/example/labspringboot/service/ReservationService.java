package com.example.labspringboot.service;

import com.example.labspringboot.domain.Reservation;
import com.example.labspringboot.domain.Rol;
import com.example.labspringboot.repository.ReservationRepository;
import com.example.labspringboot.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> listAll() {
        return repository.findAll();
    }

    public void save(Reservation reservation) {
        repository.save(reservation);
    }

    public Reservation get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
