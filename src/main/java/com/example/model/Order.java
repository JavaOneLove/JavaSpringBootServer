package com.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "zakaz")
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String date;
    private String work;
    private String status;
    private String comment;


    @OneToOne
    private User primaryUser;
    @ManyToOne
    private Vehicle primaryVehicle;

    public Order() {
    }

    public Order(String date, String work, String status, String comment, User primaryUser, Vehicle primaryVehicle) {
        this.date = date;
        this.work = work;
        this.status = status;
        this.comment = comment;
        this.primaryUser = primaryUser;
        this.primaryVehicle = primaryVehicle;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public Vehicle getPrimaryVehicle() {
        return primaryVehicle;
    }

    public void setPrimaryVehicle(Vehicle primaryVehicle) {
        this.primaryVehicle = primaryVehicle;
    }
}
