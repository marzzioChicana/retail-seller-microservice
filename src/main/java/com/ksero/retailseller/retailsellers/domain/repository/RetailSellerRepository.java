package com.ksero.retailseller.retailsellers.domain.repository;

import com.ksero.retailseller.retailsellers.domain.model.entity.RetailSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RetailSellerRepository extends JpaRepository<RetailSeller, Long> {

    List<RetailSeller> findAll();
    Optional<RetailSeller> findByRetailSellerId(Long retailSellerId);
    Boolean existsRetailSellerByRetailSellerId(Long retailSellerId);
}
