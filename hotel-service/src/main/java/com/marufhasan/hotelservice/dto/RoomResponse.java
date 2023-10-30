package com.marufhasan.hotelservice.dto;

import java.util.UUID;

public class RoomResponse {
    UUID hotelUUID;
    UUID roomId;
    int bedcount;
    String roomType;
    int roomStatus;//1 means booked 0 means avilable

    public UUID getHotelUUID() {
        return hotelUUID;
    }

    public void setHotelUUID(UUID hotelUUID) {
        this.hotelUUID = hotelUUID;
    }

    public UUID getRoomId() {
        return roomId;
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

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }
}
