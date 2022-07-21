package com.example.labspringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Fee")
@NamedStoredProcedureQuery(name = "Fee.getAlLFees", procedureName = "GetAllFees")

@NamedStoredProcedureQuery(name = "Fee.getFeeById",procedureName = "GetFee", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "@IDfee", type = Integer.class)
})

@NamedStoredProcedureQuery(name = "Fee.insertFee",procedureName = "InsertFee", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtypeVehicle", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtime", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Price", type = Float.class)
})

@NamedStoredProcedureQuery(name = "Fee.updateFee",procedureName = "UpdateFee", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDfee", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtypeVehicle", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDtime", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Price", type = Float.class)
})

@NamedStoredProcedureQuery(name = "Fee.deleteFee",procedureName = "DeleteFee", parameters =
        {@StoredProcedureParameter(mode = ParameterMode.IN, name = "IDfee", type = Integer.class)})


public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfee;
    @ManyToOne
    @JoinColumn(name = "idtypevehicle")
    private Typevehicle typevehicle;
    @ManyToOne
    @JoinColumn(name = "idtime")
    private Times times;
    private float price;

    public Fee() {
    }

    public Fee(int idfee, Typevehicle typevehicle, Times times, float price) {
        this.setIdfee(idfee);
        this.setTypevehicle(typevehicle);
        this.setTimes(times);
        this.setPrice(price);
    }

    public int getIdfee() {
        return idfee;
    }

    public void setIdfee(int idfee) {
        this.idfee = idfee;
    }

    public Typevehicle getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(Typevehicle typevehicle) {
        this.typevehicle = typevehicle;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "idfee=" + idfee +
                ", idypevehicle=" + typevehicle +
                ", idtime=" + times +
                ", price=" + price +
                '}';
    }
}
