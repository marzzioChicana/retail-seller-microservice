package com.ksero.retailseller.retailsellers.domain.service;

import com.ksero.retailseller.retailsellers.domain.model.entity.RetailSeller;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetailSellerService {

    List<RetailSeller> getAll();
    RetailSeller getById(Long retailSellerId);
    //RetailSeller getByRetailSellerUsername(String retailSellerUsername);
    RetailSeller create(RetailSeller saveRetailSeller);
    RetailSeller update(Long id, RetailSeller updateRetailSeller);
    ResponseEntity<?> delete(Long id);

}
