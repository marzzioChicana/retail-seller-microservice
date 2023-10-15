package com.ksero.retailseller.retailsellers.service;


import com.ksero.retailseller.retailsellers.domain.model.entity.RetailSeller;
import com.ksero.retailseller.retailsellers.domain.repository.RetailSellerRepository;
import com.ksero.retailseller.tools.exception.ResourceNotFoundException;
import com.ksero.retailseller.tools.exception.ResourceValidationException;
import com.ksero.retailseller.retailsellers.domain.service.RetailSellerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class RetailSellerServiceImpl implements RetailSellerService {

    private static final String entityName = "Retail Seller";
    private final RetailSellerRepository retailSellerRepository;
    private final Validator validator;

    public RetailSellerServiceImpl(RetailSellerRepository retailSellerRepository, Validator validator) {
        this.retailSellerRepository = retailSellerRepository;
        this.validator = validator;
    }

    @Override
    public List<RetailSeller> getAll() {
        return retailSellerRepository.findAll();
    }

    @Override
    public RetailSeller getById(Long retailSellerId) {
        return retailSellerRepository.findByRetailSellerId(retailSellerId).orElseThrow(() -> new ResourceNotFoundException(entityName, retailSellerId));
    }

    @Override
    public RetailSeller create(RetailSeller saveRetailSeller) {
        Set<ConstraintViolation<RetailSeller>> violations = validator.validate(saveRetailSeller);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entityName, violations);
        return retailSellerRepository.save(saveRetailSeller);
    }

    @Override
    public RetailSeller update(Long retailSellerId, RetailSeller updatedRetailSeller) {
        Set<ConstraintViolation<RetailSeller>> violations = validator.validate(updatedRetailSeller);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entityName, violations);
        Optional<RetailSeller> retailSellerOptional = retailSellerRepository.findByRetailSellerId(retailSellerId);
        if (retailSellerOptional.isPresent()) {
            RetailSeller retailSellerToUpdate = retailSellerOptional.get()
                    .withFirstName(updatedRetailSeller.getFirstName())
                    .withLastName(updatedRetailSeller.getLastName())
                    .withBirthday(updatedRetailSeller.getBirthday())
                    .withPhone(updatedRetailSeller.getPhone())
                    .withEmail(updatedRetailSeller.getEmail())
                    .withAddress(updatedRetailSeller.getAddress())
                    .withUsername(updatedRetailSeller.getUsername())
                    .withPassword(updatedRetailSeller.getPassword())
                    .withDescription(updatedRetailSeller.getDescription())
                    .withPaymentName(updatedRetailSeller.getPaymentName())
                    .withPaymentPhone(updatedRetailSeller.getPaymentPhone())
                    .withPaymentEmail(updatedRetailSeller.getPaymentEmail())
                    .withPaymentCardNumber(updatedRetailSeller.getPaymentCardNumber())
                    .withPaymentExpirationDate(updatedRetailSeller.getPaymentExpirationDate())
                    .withPaymentCVV(updatedRetailSeller.getPaymentCVV());
            return retailSellerRepository.save(retailSellerToUpdate);
        } else {
            throw new ResourceNotFoundException("Retail Seller not found.");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long retailSellerId) {
        return retailSellerRepository.findByRetailSellerId(retailSellerId).map(retailSeller -> {
            retailSellerRepository.delete(retailSeller);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entityName, retailSellerId));
    }
}
