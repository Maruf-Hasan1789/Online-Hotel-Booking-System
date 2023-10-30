package com.marufhasan.hotelservice.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Hotel")

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String address;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Hotel() {
    }

}
