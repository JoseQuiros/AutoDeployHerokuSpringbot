package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "ParkingSlot")
@NamedStoredProcedureQuery(name = "Parkingslot.getAlLParkingslots", procedureName = "GetAllParkingSlots")

@NamedStoredProcedureQuery(name = "Parkingslot.getParkingslotById",procedureName = "GetParkingSlot", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDparkingSlot", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Parkingslot.getParkingSlotInfo",procedureName = "GetParkingSlotInfo", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDparkingSlot", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDtime", type = String.class)
})

@NamedStoredProcedureQuery(name = "Parkingslot.getSlotsByParking",procedureName = "GetSlotsByParking", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDparking", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Parkingslot.insertParkingslot",procedureName = "InsertParkingSlot", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparking", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtypeVehicle", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Number", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "PreferentialSlot", type = Character.class)
})

@NamedStoredProcedureQuery(name = "Parkingslot.updateParkingslot",procedureName = "UpdateParkingSlot", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparkingSlot", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtypeVehicle", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "PreferentialSlot", type = Character.class)
})

@NamedStoredProcedureQuery(name = "Parkingslot.deleteParkingslot",procedureName = "DeleteParkingSlot", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparkingslot", type = Integer.class)})

public class Parkingslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idparkingslot;
    @ManyToOne
    @JoinColumn(name = "idparking")
    private Parking parking;
    @ManyToOne
    @JoinColumn(name = "idtypevehicle")
    private Typevehicle typevehicle;
    private int number;
    private char preferentialslot;
    private  char state;

    public Parkingslot() {
    }

    public Parkingslot(int idparkingslot, Parking parking, Typevehicle typevehicle, int number, char preferentialslot, char state) {
        this.setIdparkingslot(idparkingslot);
        this.setParking(parking);
        this.setTypevehicle(typevehicle);
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

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Typevehicle getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(Typevehicle typevehicle) {
        this.typevehicle = typevehicle;
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
                ", idparking=" + parking +
                ", idtypevehicle=" + typevehicle +
                ", number=" + number +
                ", preferentialslot=" + preferentialslot +
                ", state=" + state +
                '}';
    }
}
