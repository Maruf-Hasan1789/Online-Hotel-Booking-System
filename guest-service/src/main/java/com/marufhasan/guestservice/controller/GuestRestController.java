package com.marufhasan.guestservice.controller;


import com.marufhasan.guestservice.dto.GuestRequest;
import com.marufhasan.guestservice.dto.GuestResponse;
import com.marufhasan.guestservice.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel/guest")
public class GuestRestController {
    private final GuestService guestService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGuestProfile(@RequestBody GuestRequest guestRequest)
    {
        guestService.addUserProfile(guestRequest);
        return;
    }

    @GetMapping("/{uuid}")
    public GuestResponse getGuestDetails(@PathVariable String uuid)
    {
        GuestResponse guestResponse=guestService.getGuestDetails(uuid);
        return guestResponse;
    }

}
