package com.example.labspringboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Times {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtimes;
    private String name;

    public Times() {
    }

    public Times(int idtimes, String name) {
        this.setIdtimes(idtimes);
        this.setName(name);
    }

    public int getIdtimes() {
        return idtimes;
    }

    public void setIdtimes(int idtimes) {
        this.idtimes = idtimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Times{" +
                "idtimes=" + idtimes +
                ", name='" + name + '\'' +
                '}';
    }
}
