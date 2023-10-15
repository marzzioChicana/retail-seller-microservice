package com.ksero.retailseller.retailsellers.mapper;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("retailSellerMapperConfiguration")
public class RetailSellerMapperConfiguration {

    @Bean
    public RetailSellerMapper retailSellerMapper() {
        return new RetailSellerMapper();
    }

}
