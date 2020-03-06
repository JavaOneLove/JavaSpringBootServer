package com.example.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role extends BaseEntity{

private String name;

@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
