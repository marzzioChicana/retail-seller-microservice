package com.ksero.retailseller.retailsellers.mapper;

import com.ksero.retailseller.retailsellers.domain.model.entity.RetailSeller;
import com.ksero.retailseller.retailsellers.resource.CreateRetailSellerResource;
import com.ksero.retailseller.retailsellers.resource.RetailSellerResource;
import com.ksero.retailseller.retailsellers.resource.UpdateRetailSellerResource;
import com.ksero.retailseller.tools.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RetailSellerMapper {

    @Autowired
    EnhancedModelMapper enhancedModelMapper;

    // To Resource
    public RetailSellerResource toResource(RetailSeller retailSellerModel) {
        return enhancedModelMapper.map(retailSellerModel, RetailSellerResource.class);
    }

    public List<RetailSellerResource> toListResource(List<RetailSeller> retailSellers) {
        return enhancedModelMapper.mapList(retailSellers, RetailSellerResource.class);
    }

    // To Model
    public RetailSeller createResourceToModel(CreateRetailSellerResource createRetailSellerResource) {
        return enhancedModelMapper.map(createRetailSellerResource, RetailSeller.class);
    }

    public RetailSeller updateResourceToModel(UpdateRetailSellerResource updateRetailSellerResource) {
        return enhancedModelMapper.map(updateRetailSellerResource, RetailSeller.class);
    }

    public RetailSeller toModel(RetailSellerResource retailSellerResource) {
        return enhancedModelMapper.map(retailSellerResource, RetailSeller.class);
    }

}
