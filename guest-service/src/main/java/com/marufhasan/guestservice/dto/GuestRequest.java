package com.marufhasan.guestservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestRequest {
    private String fullName;
    private String address;
    private String email;
    private String phone;
}
