package com.example.model;

import javax.persistence.*;


@Entity
@Table
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String name;
   private double price;

   @ManyToOne
   private Order primaryOrder;

    public Work() {
    }

    public Work(String name, double price) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
