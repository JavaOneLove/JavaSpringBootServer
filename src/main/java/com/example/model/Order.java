package com.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String status;

    @OneToMany
    private Collection<Work> works;
    @ManyToOne
    private User primaryUser;
    @OneToOne
    private Vehicle primaryVehicle;

    public Order(Date date, String status, Collection<Work> works, User primaryUser, Vehicle primaryVehicle) {
        this.date = date;
        this.status = status;
        this.works = works;
        this.primaryUser = primaryUser;
        this.primaryVehicle = primaryVehicle;
    }

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

    public Collection<Work> getWorks() {
        return works;
    }

    public void setWorks(Collection<Work> works) {
        this.works = works;
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
