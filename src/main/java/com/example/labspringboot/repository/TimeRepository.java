package com.example.labspringboot.repository;


import com.example.labspringboot.domain.Times;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Times,Integer> {

    @Query(value = "GetTimes", nativeQuery = true)
    List<Times> getTimes();
}