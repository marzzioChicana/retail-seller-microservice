package com.ksero.retailseller.retailsellers.domain.model.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "retail_seller")
public class RetailSeller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long retailSellerId;

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
