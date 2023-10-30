package com.marufhasan.guestservice.repository;

import com.marufhasan.guestservice.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GuestRepository extends JpaRepository<Guest, UUID> {
    @Query(nativeQuery = true,value = "select * from guest_table where userID=:uuid")
    Guest findByUUID(UUID uuid);
}
