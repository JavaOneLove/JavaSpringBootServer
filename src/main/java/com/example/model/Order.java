package com.example.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String status;

    @ManyToOne
    private User primaryUser;
    @OneToOne
    private Vehicle primaryVehicle;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
