package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Bill")
@NamedStoredProcedureQuery(name = "Bill.getAllBills", procedureName = "GetBills")

@NamedStoredProcedureQuery(name = "Bill.insertBill",procedureName = "InsertBill", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDreservation", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Client", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Vehicle", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Parking", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ParkingSlot", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "TotalCost", type = Float.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Facturator", type = String.class)
})

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbill;
    private String client;
    private String vehicle;
    private String daterem;
    private String parking;
    private int parkingslot;
    private float totalcost;
    private String facturator;

    public Bill() {
    }

    public Bill(int idbill, String client, String vehicle, String daterem, String parking, int parkingslot, float totalcost, String facturator) {
        this.setIdbill(idbill);
        this.setClient(client);
        this.setVehicle(vehicle);
        this.setDaterem(daterem);
        this.setParking(parking);
        this.setParkingslot(parkingslot);
        this.setTotalcost(totalcost);
        this.setFacturator(facturator);
    }

    public int getIdbill() {
        return idbill;
    }

    public void setIdbill(int idbill) {
        this.idbill = idbill;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDaterem() {
        return daterem;
    }

    public void setDaterem(String daterem) {
        this.daterem = daterem;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public int getParkingslot() {
        return parkingslot;
    }

    public void setParkingslot(int parkingslot) {
        this.parkingslot = parkingslot;
    }

    public float getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(float totalcost) {
        this.totalcost = totalcost;
    }

    public String getFacturator() {
        return facturator;
    }

    public void setFacturator(String facturator) {
        this.facturator = facturator;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idbill=" + idbill +
                ", client='" + client + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", daterem='" + daterem + '\'' +
                ", parking='" + parking + '\'' +
                ", paringslot=" + parkingslot +
                ", totalcost=" + totalcost +
                ", factutator='" + facturator + '\'' +
                '}';
    }
}
