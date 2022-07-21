package com.example.labspringboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Typevehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtype;
    private String name;

    public Typevehicle() {
    }

    public Typevehicle(int idtype, String name) {
        this.setIdtype(idtype);
        this.setName(name);
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeVehicle{" +
                "idtype=" + idtype +
                ", name='" + name + '\'' +
                '}';
    }
}
