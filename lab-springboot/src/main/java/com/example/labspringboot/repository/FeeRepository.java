package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Client;
import com.example.labspringboot.domain.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {

    @Query(value = "GetAllFees", nativeQuery = true)
    List<?> getAllFees();

    @Query(value = "{ call GetFee(:IDfee)}", nativeQuery = true)
    Fee getFeeById(@Param("IDfee") Integer id);

    @Procedure(name = "Fee.insertFee") void insertFeeSP(@Param("IDtypeVehicle") int idTypeVehicle,
                                                                 @Param("IDtime") int idTime,
                                                                 @Param("Price") float price);

    @Procedure(name = "Fee.updateFee") void updateFeeSP(@Param("IDfee") int idFee,
                                                              @Param("IDtypeVehicle") int idTypeVehicle,
                                                              @Param("IDtime") int idTime,
                                                              @Param("Price") float price);

    @Procedure(name = "Fee.deleteFee") void deleteFeeSP(@Param("IDfee") int id);
}
