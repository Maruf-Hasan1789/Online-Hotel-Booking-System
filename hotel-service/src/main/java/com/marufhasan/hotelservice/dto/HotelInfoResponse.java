package com.marufhasan.hotelservice.dto;

import java.util.UUID;

public class HotelInfoResponse {
    private UUID uuid;
    private String name;
    private String address;

    public HotelInfoResponse() {
    }

    public HotelInfoResponse(String name, String address, UUID uuid) {
        this.uuid=uuid;
        this.name = name;
        this.address = address;
    }

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
}
