package com.shoppers.api.controller;

import com.shoppers.api.data.ShopperPersonalizedProductListDTO;
import com.shoppers.api.service.ShopperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Shopper Controller (Internal Interface)", description = "Endpoints for managing shopper's personalized product list")
public class ShopperController {

    @Autowired
    private ShopperService shopperService;

    @PostMapping("/api/shopper/personalized-product-list")
    @Operation(summary = "Receive and store shopper's personalized product list")
    public ResponseEntity<String> receivePersonalizedProductList(@RequestBody ShopperPersonalizedProductListDTO dto) {
        try {
            shopperService.savePersonalizedProductList(dto);
            return ResponseEntity.ok("Personalized product list stored successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}
