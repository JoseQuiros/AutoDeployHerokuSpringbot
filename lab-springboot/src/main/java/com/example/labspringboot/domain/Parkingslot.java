package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
public class Parkingslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idparkingslot;
    @ManyToOne
    @JoinColumn(name = "idparking")
    private Parking idparking;
    @ManyToOne
    @JoinColumn(name = "idtypevehicle")
    private Typevehicle idtypevehicle;
    private int number;
    private char preferentialslot;
    private  char state;

    public Parkingslot() {
    }

    public Parkingslot(int idparkingslot, Parking idparking, Typevehicle idtypevehicle, int number, char preferentialslot, char state) {
        this.setIdparkingslot(idparkingslot);
        this.setIdparking(idparking);
        this.setIdtypevehicle(idtypevehicle);
        this.setNumber(number);
        this.setPreferentialslot(preferentialslot);
        this.setState(state);
    }

    public int getIdparkingslot() {
        return idparkingslot;
    }

    public void setIdparkingslot(int idparkingslot) {
        this.idparkingslot = idparkingslot;
    }

    public Parking getIdparking() {
        return idparking;
    }

    public void setIdparking(Parking idparking) {
        this.idparking = idparking;
    }

    public Typevehicle getIdtypevehicle() {
        return idtypevehicle;
    }

    public void setIdtypevehicle(Typevehicle idtypevehicle) {
        this.idtypevehicle = idtypevehicle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getPreferentialslot() {
        return preferentialslot;
    }

    public void setPreferentialslot(char preferentialslot) {
        this.preferentialslot = preferentialslot;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Parkingslot{" +
                "idparkinslot=" + idparkingslot +
                ", idparking=" + idparking +
                ", idtypevehicle=" + idtypevehicle +
                ", number=" + number +
                ", preferentialslot=" + preferentialslot +
                ", state=" + state +
                '}';
    }
}
