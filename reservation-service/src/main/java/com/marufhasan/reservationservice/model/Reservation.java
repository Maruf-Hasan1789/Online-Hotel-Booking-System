package com.marufhasan.reservationservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "ReservationTable")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reservationID;
    private String hotelName;
    private String roomType;
    private LocalDate startDate;
    private LocalDate endDate;
 //   private UUID userID;
    private Status status;
    private int numberOfRooms;
 }
