package com.cryptocurrencyOrders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private UUID id;

    private String firstName;
    private String lastname;
    private String mobileNumber;
    private String  emailId;
    private String password;
    private String status;
    private String  role;
    private BigInteger quantity;



}
