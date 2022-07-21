package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Fee;
import com.example.labspringboot.domain.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {


    @Query(value = "GetAllParkings", nativeQuery = true)
    List<?> getAllParkings();

    @Query(value = "{ call GetParking(:IDparking)}", nativeQuery = true)
    Parking getParkingById(@Param("IDparking") Integer id);

    @Procedure(name = "Parking.insertParking") void insertParkingSP(@Param("ParkingName") String parkingName);

    @Procedure(name = "Parking.updateParking") void updateParkingSP(@Param("IDparking") int idParking,
                                                        @Param("ParkingName") String parkingName);

    @Procedure(name = "Parking.deleteParking") void deleteParkingSP(@Param("IDparking") int id);

}
