package com.marufhasan.hotelservice.service;


import com.marufhasan.hotelservice.dto.*;
import com.marufhasan.hotelservice.model.Hotel;
import com.marufhasan.hotelservice.model.Room;
import com.marufhasan.hotelservice.repository.HotelRepository;
import com.marufhasan.hotelservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public HotelService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;

    }

    public void addNewHotel(HotelInfoResponse hotelInfoResponse)
    {
        Hotel hotel=new Hotel();
        hotel.setUuid(UUID.randomUUID());
        hotel.setAddress(hotelInfoResponse.getAddress());
        hotel.setName(hotelInfoResponse.getName());
        hotelRepository.save(hotel);
        return ;
    }

    public List<HotelInfoResponse> getAllHotels() {
        List<Hotel>hotelsList=hotelRepository.findAll();
        List<HotelInfoResponse> hotelInfoResponseList =new ArrayList<>();
        for(Hotel hotel:hotelsList)
        {
            HotelInfoResponse hotelInfoResponse =new HotelInfoResponse();
            hotelInfoResponse.setUuid(hotel.getUuid());
            hotelInfoResponse.setName(hotel.getName());
            hotelInfoResponse.setAddress(hotel.getAddress());
            hotelInfoResponseList.add(hotelInfoResponse);
        }
        return hotelInfoResponseList;
    }


    public HotelInfoResponse getHotel(String name) {
        Hotel hotel=hotelRepository.findByName(name);
        HotelInfoResponse hotelInfoResponse =new HotelInfoResponse();
        hotelInfoResponse.setUuid(hotel.getUuid());
        hotelInfoResponse.setAddress(hotel.getAddress());
        hotelInfoResponse.setName(hotel.getName());
        return hotelInfoResponse;
    }

    public void addNewRoom(RoomRequest roomRequest) {
        createRoom(roomRequest);
        //addRoomToInventory(room);
        return;
    }

    private void  createRoom(RoomRequest roomRequest)
    {
        String hotelName=roomRequest.getHotelName();
        Hotel hotel=hotelRepository.findByName(hotelName);
        Room room=new Room();
        room.setHotelUUID(hotel.getUuid());
        room.setRoomType(roomRequest.getRoomType());
        room.setBedcount(roomRequest.getNumOfBeds());
        room.setRoomStatus(0);

        for(int i=0;i<roomRequest.getNumberOfRooms();i++)
        {
            room.setRoomId(UUID.randomUUID());
            roomRepository.save(room);
        }
        return ;
    }
    public List<RoomResponse> getAllRooms(String hotelName,String roomType)
    {
        Hotel hotel=hotelRepository.findByName(hotelName);
        List<Room>roomList=roomRepository.findAllByhotelUUIDandroomType(hotel.getUuid(),roomType);
        List<RoomResponse>roomResponseList=new ArrayList<>();
        for(Room room:roomList)
        {
            RoomResponse roomResponse=new RoomResponse();
            roomResponse.setRoomId(room.getRoomId());
            roomResponse.setRoomStatus(room.getRoomStatus());
            roomResponse.setBedcount(room.getBedcount());
            roomResponse.setRoomType(room.getRoomType());
            roomResponse.setHotelUUID(room.getHotelUUID());
            roomResponseList.add(roomResponse);
        }

        return roomResponseList;
    }


    public Integer getNumberOfRooms(String hotelName, String roomType) {
        List<RoomResponse>roomResponseList=getAllRooms(hotelName,roomType);
        return roomResponseList.size();
    }
}
