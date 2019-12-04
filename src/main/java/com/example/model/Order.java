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
}
