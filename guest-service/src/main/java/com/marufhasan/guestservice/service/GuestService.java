package com.marufhasan.guestservice.service;

import com.marufhasan.guestservice.dto.GuestRequest;
import com.marufhasan.guestservice.dto.GuestResponse;
import com.marufhasan.guestservice.model.Guest;
import com.marufhasan.guestservice.repository.GuestRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class GuestService {
    private final GuestRepository guestRepository;
    public void addUserProfile(GuestRequest guestRequest)
    {
        Guest guest=new Guest();
        guest.setUserID(UUID.randomUUID());
        System.out.println(guest.getUserID());
        guest.setEmail(guestRequest.getEmail());
        guest.setPhone(guestRequest.getPhone());
        guest.setAddress(guestRequest.getAddress());
        guest.setFullName(guestRequest.getFullName());
        guestRepository.save(guest);
        return;
    }
    public GuestResponse getGuestDetails(String uuidString)
    {
        UUID uuid=UUID.fromString(uuidString);

        Optional<Guest>guestOptional=guestRepository.findById(uuid);

        GuestResponse guestResponse=new GuestResponse();
        if(guestOptional.isPresent())
        {
            System.out.println("Present");
            Guest guest=guestOptional.get();
            guestResponse.setAddress(guest.getAddress());
            guestResponse.setPhone(guest.getPhone());
            guestResponse.setEmail(guest.getEmail());
            guestResponse.setFullName(guest.getFullName());
            guestResponse.setUserID(guest.getUserID());
        }
        else
        {
            System.out.println("Absent");
            guestResponse=null;
        }

        return guestResponse;
    }

}
