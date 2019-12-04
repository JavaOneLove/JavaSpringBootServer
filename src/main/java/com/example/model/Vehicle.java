package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mark;
    private String model;
    private String color;
    private String registrationNumber;
    private Date ProductionDate;

    public Vehicle(int id, String mark, String model, String color, String registrationNumber, Date productionDate) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        ProductionDate = productionDate;
    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getProductionDate() {
        return ProductionDate;
    }

    public void setProductionDate(Date productionDate) {
        ProductionDate = productionDate;
    }
}
