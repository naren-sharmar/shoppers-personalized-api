package com.shoppers.api.controller;

import com.shoppers.api.data.ProductDTO;
import com.shoppers.api.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Product Controller (Internal Interface)", description = "Endpoints for managing product list")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/product-metadata")
    public ResponseEntity<String> receiveProductMetadata(@RequestBody ProductDTO productDTO) {
        try {
            productService.saveProductMetadata(productDTO);
            return ResponseEntity.ok("Product metadata stored successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}
