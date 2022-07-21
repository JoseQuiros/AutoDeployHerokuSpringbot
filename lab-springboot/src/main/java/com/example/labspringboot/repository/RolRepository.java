package com.example.labspringboot.repository;

import com.example.labspringboot.domain.Rol;
import com.example.labspringboot.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query(value = "GetAllRoles", nativeQuery = true)
    List<?> getAllRoles();

    @Query(value = "{ call GetRol(:IDrol)}", nativeQuery = true)
    Rol getRol(@Param("IDrol") Integer id);

    @Procedure(name = "Rol.insertRol") void insertRol(@Param("Name") String name,
                                                        @Param("Authority") int authority);

    @Procedure(name = "Users.updateRol")void updateRol(@Param("IDrol") int idrol,
                                                         @Param("Authority") int authority);

    @Procedure(name = "Users.deleteUser") void deleteRol(@Param("IDrol") int id);


}
