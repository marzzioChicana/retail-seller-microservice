package com.ksero.retailseller.retailsellers.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RetailSellerResource {
    private Long id;
    private String firstName;
    private String address;
    private String lastName;
    private String birthday;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String description;
    private String paymentName;
    private String paymentPhone;
    private String paymentEmail;
    private String paymentCardNumber;
    private String paymentExpirationDate;
    private String paymentCVV;
}
