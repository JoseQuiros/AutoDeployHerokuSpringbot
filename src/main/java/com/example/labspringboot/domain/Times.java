package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Times")
@NamedStoredProcedureQuery(name = "Times.getTimes", procedureName = "GetTimes")

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
