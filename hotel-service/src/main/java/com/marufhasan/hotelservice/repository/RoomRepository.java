package com.marufhasan.hotelservice.repository;

import com.marufhasan.hotelservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

    @Query(value = "select * from Room_Table rtable where rtable.hotelUUID=:uuid and rtable.room_Type=:roomType",nativeQuery = true)
    List<Room>findAllByhotelUUIDandroomType(UUID uuid,String roomType);

}
