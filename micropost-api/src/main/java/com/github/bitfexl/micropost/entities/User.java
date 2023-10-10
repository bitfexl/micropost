package com.github.bitfexl.micropost.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity(name = "users") // the name "User" will cause an error when using h2 database
public class User extends PanacheEntity {
    public String name;
    public String about;
}
