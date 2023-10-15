package com.ksero.retailseller.retailsellers.api;

import com.ksero.retailseller.retailsellers.domain.service.RetailSellerService;
import com.ksero.retailseller.retailsellers.mapper.RetailSellerMapper;
import com.ksero.retailseller.retailsellers.resource.CreateRetailSellerResource;
import com.ksero.retailseller.retailsellers.resource.RetailSellerResource;
import com.ksero.retailseller.retailsellers.resource.UpdateRetailSellerResource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/retail-seller")
public class RetailSellerController {
    private final RetailSellerService retailSellerService;
    private final RetailSellerMapper mapper;

    public RetailSellerController(RetailSellerService retailSellerService, RetailSellerMapper mapper) {
        this.retailSellerService = retailSellerService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RetailSellerResource> getAll() {
        return mapper.toListResource(retailSellerService.getAll());
    }


    @GetMapping("{retailSellerId}")
    public RetailSellerResource getRetailSellerById(@PathVariable Long retailSellerId) {
        return mapper.toResource(retailSellerService.getById(retailSellerId));
    }

    @PostMapping
    public RetailSellerResource createRetailSeller(@RequestBody CreateRetailSellerResource resource) {
        return mapper.toResource(retailSellerService.create(mapper.createResourceToModel(resource)));
    }

    @PutMapping("{retailSellerId}")
    public RetailSellerResource updateRetailSeller(@PathVariable Long retailSellerId,
                                                 @RequestBody @Valid UpdateRetailSellerResource resource) {
        return mapper.toResource(retailSellerService.update(retailSellerId, mapper.updateResourceToModel(resource)));
    }

    @DeleteMapping("{retailSellerId}")
    public ResponseEntity<?> deleteRetailSeller(@PathVariable Long retailSellerId) {
        return retailSellerService.delete(retailSellerId);
    }

}
