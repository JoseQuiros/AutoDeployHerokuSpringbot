package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Reservation;
import com.example.labspringboot.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {


    @Query(value = "GetAllReservations", nativeQuery = true)
    List<?> getAllReservations();

    @Query(value = "{ call GetReservationById(:IDreservation)}", nativeQuery = true)
    Object getReservationById(@Param("IDreservation") Integer id);

    @Query(value = "{ call GetAllReservationsByClient(:IDclient)}", nativeQuery = true)
    List<?> getAllReservationsByClient(@Param("IDclient") Integer id);

    @Procedure(name = "Reservation.insertReservation") void insertReservationSP(@Param("IDparking") int idParking ,
                                                                    @Param("IDtime") int idTime,
                                                                    @Param("IDparkingslot") int idParkingslot,
                                                                    @Param("IDclient") int idClient,
                                                                    @Param("Date") String date,
                                                                    @Param("CantTime") int contTime);

    @Procedure(name = "Reservation.consultCost") Object consultCostSP(@Param("IDparking") int idParking ,
                                                                                @Param("IDtime") int idTime,
                                                                                @Param("SlotNumber") int slotNumber,
                                                                                @Param("IDclient") int idClient,
                                                                                @Param("Date") String date,
                                                                                @Param("CantTime") int contTime);

    @Procedure(name = "Reservation.cancelReservation") void cancelReservationSP(@Param("IDreservation") int id);

}
