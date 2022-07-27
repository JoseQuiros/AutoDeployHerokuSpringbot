package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Reservation")
@NamedStoredProcedureQuery(name = "Reservation.getAllReservations", procedureName = "GetAllReservation")

@NamedStoredProcedureQuery(name = "Reservation.getReservationById",procedureName = "GetReservationById", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDreservation", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Reservation.getAllReservationsByClient",procedureName = "GetAllReservationsByClient", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDclient", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Reservation.insertReservation",procedureName = "InsertReservation", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparking", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtime", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "SlotNumber", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDclient", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Date", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "CantTime", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Reservation.consultCost",procedureName = "consultCost", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparking", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtime", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "SlotNumber", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDclient", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Date", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "CantTime", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Reservation.cancelReservation",procedureName = "cancelReservation", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDreservation", type = Integer.class)})

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreservation;
    private int idparking;
    private int idparkingslot;
    private int idclient;
    private int idvehicle;
    private int canttime;
    private int idtime;
    private float costtotal;
    private String initdate;
    private String finaldate;
    private char state;

    public Reservation() {
    }

    public Reservation(int idreservation, int idparking, int idparkingslot, int idclient, int idvehicle, int canttime, int idtime, float costtotal, String initdate, String finaldate, char state) {
        this.setIdreservation(idreservation);
        this.setIdparking(idparking);
        this.setIdparkingslot(idparkingslot);
        this.setIdclient(idclient);
        this.setIdvehicle(idvehicle);
        this.setCanttime(canttime);
        this.setIdtime(idtime);
        this.setCosttotal(costtotal);
        this.setInitdate(initdate);
        this.setFinaldate(finaldate);
        this.setState(state);
    }

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public int getIdparking() {
        return idparking;
    }

    public void setIdparking(int idparking) {
        this.idparking = idparking;
    }

    public int getIdparkingslot() {
        return idparkingslot;
    }

    public void setIdparkingslot(int idparkingslot) {
        this.idparkingslot = idparkingslot;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdvehicle() {
        return idvehicle;
    }

    public void setIdvehicle(int idvehicle) {
        this.idvehicle = idvehicle;
    }

    public int getCanttime() {
        return canttime;
    }

    public void setCanttime(int canttime) {
        this.canttime = canttime;
    }

    public int getIdtime() {
        return idtime;
    }

    public void setIdtime(int idtime) {
        this.idtime = idtime;
    }

    public float getCosttotal() {
        return costtotal;
    }

    public void setCosttotal(float costtotal) {
        this.costtotal = costtotal;
    }

    public String getInitdate() {
        return initdate;
    }

    public void setInitdate(String initdate) {
        this.initdate = initdate;
    }

    public String getFinaldate() {
        return finaldate;
    }

    public void setFinaldate(String finaldate) {
        this.finaldate = finaldate;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idreservation=" + idreservation +
                ", idparking=" + idparking +
                ", idparkingslot=" + idparkingslot +
                ", idclient=" + idclient +
                ", idvehicle=" + idvehicle +
                ", canttime=" + canttime +
                ", idtime=" + idtime +
                ", costtotal=" + costtotal +
                ", initdate='" + initdate + '\'' +
                ", finaldate='" + finaldate + '\'' +
                ", state=" + state +
                '}';
    }
}
