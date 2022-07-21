package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Client")
@NamedStoredProcedureQuery(name = "Client.getAlLClient", procedureName = "GetAllClient")

@NamedStoredProcedureQuery(name = "Client.getClientById",procedureName = "GetClient", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDclient", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Client.insertClient",procedureName = "InsertClient", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDvehicle", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "DNI", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Age", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Telephone", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Clave", type = String.class)
})

@NamedStoredProcedureQuery(name = "Client.updateClient",procedureName = "UpdateClient", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDclient", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDvehicle", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "DNI", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Age", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Telephone", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Clave", type = String.class)
})

@NamedStoredProcedureQuery(name = "Client.deleteClient",procedureName = "DeleteClient", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDclient", type = Integer.class)})


public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idclient;
    @ManyToOne
    @JoinColumn(name = "idvehicle")
    private Vehicle vehicle;
    private String name;
    private String dni;
    private int age;
    private String telephone;
    private String email;
    private String clave;
    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;
    private char state;

    public Client() {
    }

    public Client(int idclient, Vehicle vehicle, String name, String dni, int age, String telephone, String email, String clave, Rol rol, char state) {
        this.idclient = idclient;
        this.vehicle = vehicle;
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
        this.state = state;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idclient=" + idclient +
                ", idvehicle=" + vehicle +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + clave + '\'' +
                ", idrol=" + rol +
                ", state=" + state +
                '}';
    }
}
