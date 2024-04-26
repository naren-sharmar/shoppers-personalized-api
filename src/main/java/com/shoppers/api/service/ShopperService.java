package com.shoppers.api.service;

import com.shoppers.api.data.ProductShelfDTO;
import com.shoppers.api.data.ShopperPersonalizedProductListDTO;
import com.shoppers.api.entity.PersonalizedProduct;
import com.shoppers.api.repo.PersonalizedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopperService {

    @Autowired
    private PersonalizedProductRepository personalizedProductRepository;

    public void savePersonalizedProductList(ShopperPersonalizedProductListDTO shopperDTO) {
        List<ProductShelfDTO> shelf = shopperDTO.getShelf();
        for (ProductShelfDTO productShelfDTO : shelf) {
            PersonalizedProduct personalizedProduct = new PersonalizedProduct();
            saveEachPersonalizedProductEntry(shopperDTO, productShelfDTO, personalizedProduct);
        }
    }

    private void saveEachPersonalizedProductEntry(ShopperPersonalizedProductListDTO shopperDTO, ProductShelfDTO productShelfDTO, PersonalizedProduct personalizedProduct) {
        personalizedProduct.setShopperId(shopperDTO.getShopperId());
        personalizedProduct.setProductId(productShelfDTO.getProductId());
        personalizedProduct.setRelevancyScore(productShelfDTO.getRelevancyScore());
        personalizedProductRepository.save(personalizedProduct);
    }

}

