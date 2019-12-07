package com.example.model;

import javax.persistence.*;

@Entity
@Table
public class OrderSparePart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User primaryUser;
    @ManyToOne
    private SparePart primarySparePart;

    public OrderSparePart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public SparePart getPrimarySparePart() {
        return primarySparePart;
    }

    public void setPrimarySparePart(SparePart primarySparePart) {
        this.primarySparePart = primarySparePart;
    }
}
