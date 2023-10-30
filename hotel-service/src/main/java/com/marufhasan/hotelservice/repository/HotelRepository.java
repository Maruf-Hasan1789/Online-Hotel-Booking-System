package com.marufhasan.hotelservice.repository;

import com.marufhasan.hotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    Hotel findByName(String name);


    @Query(nativeQuery = true,value = "Select name from hotel h where h.uuid = :hotelID")
    String findByUUID(@Param("hotelID") UUID hotelID);
}
