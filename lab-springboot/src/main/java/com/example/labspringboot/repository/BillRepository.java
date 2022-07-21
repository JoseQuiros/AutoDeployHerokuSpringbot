package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {


    @Query(value = "GetBills", nativeQuery = true)
    List<Bill> getAllBills();

    @Procedure(name = "Bill.insertBill") void insertBillSP(@Param("IDreservation") int idReservation,
                                                           @Param("Client") String client,
                                                           @Param("Vehicle") String vehicle,
                                                           @Param("Parking") String parking,
                                                           @Param("ParkingSlot") int parkingSlot,
                                                           @Param("TotalCost") float totalCost,
                                                           @Param("Facturator") String facturator);


}
