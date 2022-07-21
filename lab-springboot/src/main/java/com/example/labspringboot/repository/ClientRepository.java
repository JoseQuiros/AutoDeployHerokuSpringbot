package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Client;
import com.example.labspringboot.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "GetAllClients", nativeQuery = true)
    List<?> getAllClients();

    @Query(value = "{ call GetClient(:IDclient)}", nativeQuery = true)
    Client getClientById(@Param("IDclient") Integer id);

    @Procedure(name = "Client.insertClient") void insertClientSP(@Param("IDvehicle") int idVehicle,
                                                                @Param("Name") String name,
                                                                @Param("DNI") String dni,
                                                                @Param("Age") int age,
                                                                @Param("Telephone") String telephone,
                                                                @Param("Email") String email,
                                                                @Param("Clave") String clave );

    @Procedure(name = "Client.updateClient") void updateClientSP(@Param("IDclient") int idClient,
                                                            @Param("IDvehicle") int idVehicle,
                                                            @Param("Name") String name,
                                                            @Param("DNI") String dni,
                                                            @Param("Age") int age,
                                                            @Param("Telephone") String telephone,
                                                            @Param("Email") String email,
                                                            @Param("Clave") String clave );

    @Procedure(name = "Client.deleteClient") void deleteClientSP(@Param("IDclient") int id);

}
