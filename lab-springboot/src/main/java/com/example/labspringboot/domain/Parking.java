package com.example.labspringboot.domain;


import javax.persistence.*;

@Entity
@Table(name = "Parking")
@NamedStoredProcedureQuery(name = "Parking.getAlLParkings", procedureName = "GetAllParkings")

@NamedStoredProcedureQuery(name = "Parking.getParkingById",procedureName = "GetParking", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDparking", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Parking.insertParking",procedureName = "InsertParking", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ParkingName", type = String.class)
})

@NamedStoredProcedureQuery(name = "Parking.updateParking",procedureName = "UpdateParking", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparking", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ParkingName", type = String.class)
})

@NamedStoredProcedureQuery(name = "Parking.deleteParking",procedureName = "DeleteParking", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDparking", type = Integer.class)})

public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idparking;
    private String parkingname;

    public Parking() {
    }

    public Parking(int idparking, String parkingname) {
        this.setIdparking(idparking);
        this.setParkingname(parkingname);
    }

    public int getIdparking() {
        return idparking;
    }

    public void setIdparking(int idparking) {
        this.idparking = idparking;
    }

    public String getParkingname() {
        return parkingname;
    }

    public void setParkingname(String parkingname) {
        this.parkingname = parkingname;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "idparking=" + idparking +
                ", parkingname='" + parkingname + '\'' +
                '}';
    }
}
