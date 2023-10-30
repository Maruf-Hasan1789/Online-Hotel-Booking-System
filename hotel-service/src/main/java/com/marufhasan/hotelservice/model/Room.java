package com.marufhasan.hotelservice.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "RoomTable")

public class Room {
    UUID hotelUUID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID roomId;
    int bedcount;
    String roomType;
    int roomStatus;//1 means booked 0 means avilable

    public Room(UUID hotelUUID, UUID roomId, int bedcount, String roomType, int roomStatus) {
        this.hotelUUID = hotelUUID;
        this.roomId = roomId;
        this.bedcount = bedcount;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public Room() {
    }



    public UUID getHotelUUID() {
        return hotelUUID;
    }

    public void setHotelUUID(UUID hotelUUID) {
        this.hotelUUID = hotelUUID;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public int getBedcount() {
        return bedcount;
    }

    public void setBedcount(int bedcount) {
        this.bedcount = bedcount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
