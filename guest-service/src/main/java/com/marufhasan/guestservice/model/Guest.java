package com.marufhasan.guestservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Entity
@Table(name = "GuestTable")
@NoArgsConstructor
@AllArgsConstructor


public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userID;
    private String fullName;
    private String address;
    private String email;
    private String phone;
}
