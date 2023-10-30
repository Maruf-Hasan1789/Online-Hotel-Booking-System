package com.marufhasan.reservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationRequest {
    private String hotelName;
    private String roomType;
    private String startDate;
    private String endDate;
  //  private UUID userID;
    private Integer numberOfRooms;

}
