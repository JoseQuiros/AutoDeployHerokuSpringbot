package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Users;
import com.example.labspringboot.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query(value = "GetAllVehicles", nativeQuery = true)
    List<?> getAllVehicles();

    @Query(value = "{ call GetVehicle(:IDvehicle)}", nativeQuery = true)
    Vehicle getVehicleById(@Param("IDvehicle") Integer id);

    @Query(value = "{ call GetVehicleByClient(:IDclient)}", nativeQuery = true)
    List<Vehicle> getVehicleByClient(@Param("IDclient") Integer id);

    @Procedure(name = "Vehicle.insertVehicle") void insertVehicleSP(@Param("IDtype") int idType ,
                                                                    @Param("Brand") String brand,
                                                                    @Param("Model") String model,
                                                                    @Param("Color") String color,
                                                                    @Param("Year") int year,
                                                                    @Param("Register") String register,
                                                                    @Param("Description") String description);


    @Procedure(name = "Vehicle.updateVehicle") void updateVehicleSP(@Param("IDvehicle") int idVehicle,
                                                                    @Param("IDtype") int idType ,
                                                                    @Param("Brand") String brand,
                                                                    @Param("Model") String model,
                                                                    @Param("Color") String color,
                                                                    @Param("Year") int year,
                                                                    @Param("Register") String register,
                                                                    @Param("Description") String description);

    @Procedure(name = "Vehicle.deleteVehicle") void deleteVehicleSP(@Param("IDvehicle") int id);

}
