package com.shoppers.api.service;

import com.shoppers.api.data.ProductDTO;
import com.shoppers.api.entity.Product;
import com.shoppers.api.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProductMetadata(ProductDTO productDTO) {
        // Convert ProductDTO to Product entity
        Product product = convertToEntity(productDTO);

        // Save product metadata
        productRepository.save(product);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setBrand(productDTO.getBrand());
        product.setCategory(productDTO.getCategory());
        return product;
    }
}
