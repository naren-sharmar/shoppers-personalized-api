package com.shoppers.api.service;

import com.shoppers.api.entity.PersonalizedProduct;
import com.shoppers.api.entity.Product;
import com.shoppers.api.repo.PersonalizedProductRepository;
import com.shoppers.api.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalizedProductService {

    @Autowired
    private PersonalizedProductRepository personalizedProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getPersonalizedProducts(String shopperId, String category, String brand, int limit) {
        // Implement logic to fetch personalized product information based on provided parameters
        List<PersonalizedProduct> byShopperId = personalizedProductRepository.findByShopperId(shopperId);
        List<Product> productList = new ArrayList<>();
        for (PersonalizedProduct personalizedProduct : byShopperId) {
            String productId = personalizedProduct.getProductId();
            Product product = productRepository.findByProductId(productId);
            productList.add(product);
        }
        return productList;
    }

}
