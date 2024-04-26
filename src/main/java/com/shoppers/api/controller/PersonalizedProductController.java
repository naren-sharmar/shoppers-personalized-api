package com.shoppers.api.controller;

import com.shoppers.api.entity.Product;
import com.shoppers.api.service.PersonalizedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonalizedProductController {

    @Autowired
    private PersonalizedProductService personalizedProductService;

    @GetMapping("/api/personalized-products")
    public ResponseEntity<List<Product>> getPersonalizedProducts(@RequestParam String shopperId, @RequestParam(required = false) String category, @RequestParam(required = false) String brand, @RequestParam(defaultValue = "10") int limit) {

        List<Product> personalizedProducts = personalizedProductService.getPersonalizedProducts(shopperId, category, brand, limit);
        return ResponseEntity.ok(personalizedProducts);
    }
}
