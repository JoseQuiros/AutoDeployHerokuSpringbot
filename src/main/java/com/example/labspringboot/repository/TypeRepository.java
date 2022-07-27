package com.example.labspringboot.repository;


import com.example.labspringboot.domain.Typevehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Typevehicle, Integer> {

    @Query(value = "GetTypes", nativeQuery = true)
    List<Typevehicle> getTypes();
}
