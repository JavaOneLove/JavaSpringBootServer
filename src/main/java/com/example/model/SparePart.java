package com.example.model;

import javax.persistence.*;

@Entity
@Table
public class SparePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String mark;
    private String model;
    private double price;
    private int value;
    private String Manufacturer;

    public SparePart(int id, String name, String mark, String model, double price, int value, String manufacturer) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.value = value;
        Manufacturer = manufacturer;
    }

    public SparePart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}
