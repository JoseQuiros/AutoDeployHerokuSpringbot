package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Parkingslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingslotRepository extends JpaRepository<Parkingslot, Integer> {
}
