package com.marufhasan.hotelservice.controller;


import com.marufhasan.hotelservice.dto.HotelInfoResponse;
import com.marufhasan.hotelservice.dto.RoomRequest;
import com.marufhasan.hotelservice.dto.RoomResponse;
import com.marufhasan.hotelservice.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotel")
public class HotelRestController {
    private final HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/property")
    public ResponseEntity addNewHotel(@RequestBody HotelInfoResponse hotelInfoResponse)
    {
        hotelService.addNewHotel(hotelInfoResponse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/property")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelInfoResponse> getAllHotels()
    {
        List<HotelInfoResponse>hotelList=hotelService.getAllHotels();
        return hotelList;
    }
    @GetMapping("/property/{name}")
    @ResponseStatus(HttpStatus.OK)
    public HotelInfoResponse getHotel(@PathVariable String name)
    {
       // System.out.println(name);
        HotelInfoResponse hotelInfoResponse =hotelService.getHotel(name);
        return hotelInfoResponse;
    }

    @PostMapping("/property/room")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addNewRoom(@RequestBody RoomRequest roomRequest)
    {
        hotelService.addNewRoom(roomRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/property/room")
    public List<RoomResponse> getAllRooms(@RequestParam(name = "hotelName")String hotelName,@RequestParam(name = "roomType") String roomType)
    {
        List<RoomResponse>roomResponseList=hotelService.getAllRooms(hotelName,roomType);
        return roomResponseList;
    }
    @GetMapping("/property/room/{hotelName}/{roomType}")
    public Integer getNumberOfroomsInHotel(@PathVariable(name = "hotelName")String hotelName,@PathVariable(name = "roomType")String roomType)
    {
        return hotelService.getNumberOfRooms(hotelName,roomType);
    }
}
