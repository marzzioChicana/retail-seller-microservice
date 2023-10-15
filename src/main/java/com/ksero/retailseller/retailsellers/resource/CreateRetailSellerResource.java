package com.ksero.retailseller.retailsellers.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateRetailSellerResource {
    private String firstName;
    private String lastName;
    private String birthday;
    private String phone;
    private String email;
    private String address;
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
