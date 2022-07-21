package com.example.labspringboot.domain;

import javax.persistence.*;
@Entity
@Table(name = "Rol")
@NamedStoredProcedureQuery(name = "Rol.getAllRoles", procedureName = "GetAllRoles")

@NamedStoredProcedureQuery(name = "Rol.getRolById",procedureName = "GetRol", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDrol", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "rol.insertRol", procedureName = "InsertRol", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Authority", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Rol.updateRol",procedureName = "UpdateRol", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDrol", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Authority", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Rol.deleteRol",procedureName = "DeleteRol", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDrol", type = Integer.class)})


public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;
    private String name;
    private int authority;

    public Rol() {

    }

    public Rol(int idrol, String name, int authority) {
        this.setIdrol(idrol);
        this.setName(name);
        this.setAuthority(authority);
    }


    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idrol +
                ", name='" + name + '\'' +
                ", authority=" + authority +
                '}';
    }
}