package com.marufhasan.reservationservice.controller;


import com.marufhasan.reservationservice.dto.ReservationRequest;
import com.marufhasan.reservationservice.dto.RoomResponse;
import com.marufhasan.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/hotel/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    String createReservation(@RequestBody ReservationRequest reservationRequest)
    {
        String status=reservationService.createReservation(reservationRequest);
        return status;
    }

    @GetMapping()
    Flux<RoomResponse> getAllAvailableRooms(@RequestParam(name="hotelName")String hotelName,@RequestParam(name="startDateString") String startDateString,@RequestParam(name="endDateString")  String endDateString)
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(startDateString, formatter);
        LocalDate endDate = LocalDate.parse(endDateString, formatter);
        System.out.println(startDate);
        System.out.println(endDate);
        Flux<RoomResponse> roomResponseList= reservationService.getAllAvailableRooms();
        return roomResponseList;
    }
}
