package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@NamedStoredProcedureQuery(name = "Users.getAllUsers", procedureName = "GetAllUser")

@NamedStoredProcedureQuery(name = "Users.getUserById",procedureName = "GetUser", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDuser", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Users.insertUser",procedureName = "InsertUser", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDrol", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "DNI", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Age", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Telephone", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Clave", type = String.class)
})

@NamedStoredProcedureQuery(name = "Users.updateUser",procedureName = "UpdateUser", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDuser", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDrol", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "DNI", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Age", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Telephone", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Clave", type = String.class)
})

@NamedStoredProcedureQuery(name = "Users.deleteUser",procedureName = "DeleteUser", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDuser", type = Integer.class)})


public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    private String name;
    private String dni;
    private int age;
    private String telephone;
    private String email;
    private String clave;
    private char state;
    @ManyToOne
    @JoinColumn(name = "IDrol")
    private Rol rol;

    public Users() {
    }

    public Users(int iduser, Rol rol, String name, String dni, int age, String telephone, String email, String clave, char state) {
        this.setIduser(iduser);
        this.setRol(rol);
        this.setName(name);
        this.setDni(dni);
        this.setAge(age);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setClave(clave);
        this.setState(state);
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int idUser) {
        this.iduser = iduser;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + clave + '\'' +
                ", state=" + state +
                ", rol=" + rol +
                '}';
    }
}
