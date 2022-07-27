package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Fee;
import com.example.labspringboot.domain.Parkingslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingslotRepository extends JpaRepository<Parkingslot, Integer> {

    @Query(value = "GetAllParkingslots", nativeQuery = true)
    List<Parkingslot> getAllParkingslots();

    @Query(value = "{ call GetParkingslot(:IDparkingSlot)}", nativeQuery = true)
    Parkingslot getParkingslotById(@Param("IDparkingSlot") Integer id);

    @Query(value = "{ call GetSlotsByParking(:IDparking)}", nativeQuery = true)
    List<Parkingslot>   getSlotsByParking(@Param("IDparking") Integer id);

    @Procedure(name = "Parkingslot.getParkingslotInfo") List<?> getParkingslotInfo(@Param("IDparkingSlot") Integer idparkingslot,
                                                                                 @Param("IDtime") String time);

    @Procedure(name = "Parkingslot.insertParkingslot") void insertParkingslotSP(@Param("IDparking") int idParking,
                                                                                @Param("IDtypeVehicle") int idTypeVehicle,
                                                                                @Param("Number") int number,
                                                                                @Param("PreferentialSlot") char preferentialSlot);

    @Procedure(name = "Parkingslot.updateParkingslot") void updateParkingslotSP(@Param("IDparkingSlot") int idParkingslot,
                                                                                @Param("IDtypeVehicle") int idTypeVehicle,
                                                                                @Param("PreferentialSlot") char preferentialSlot);

    @Procedure(name = "Parkingslot.deleteParkingslot") void deleteParkingslotSP(@Param("IDparkingslot") int id);

}
