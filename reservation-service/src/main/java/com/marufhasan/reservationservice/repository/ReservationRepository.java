package com.marufhasan.reservationservice.repository;

import com.marufhasan.reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    @Query(value = "select sum(rtable.number_Of_Rooms) from Reservation_Table rtable where rtable.hotel_name=:hotelName and rtable.room_Type=:roomType and (((rtable.start_Date>=:startDate and (rtable.start_date<=:endDate)) or (rtable.start_Date<=:startDate and rtable.end_Date>=:startDate)))",nativeQuery = true)
    Integer findNumberOfBookedRooms(LocalDate startDate, LocalDate endDate, String hotelName, String roomType);
    // @Query(value = "Select count(*) from RoomTable r wehere r.hotelId=:hotelID and r.roomType=:roomType",nativeQuery = true)
    //List<Room> findHotelRooms(UUID hotelID, String roomType);
}
