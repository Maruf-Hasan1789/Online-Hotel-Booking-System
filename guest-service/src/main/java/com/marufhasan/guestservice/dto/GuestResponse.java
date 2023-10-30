package com.marufhasan.guestservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestResponse {
    private UUID userID;
    private String fullName;
    private String address;
    private String email;
    private String phone;
}
