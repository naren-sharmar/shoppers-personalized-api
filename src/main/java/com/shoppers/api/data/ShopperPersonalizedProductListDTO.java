package com.shoppers.api.data;

import lombok.Data;

import java.util.List;

@Data
public class ShopperPersonalizedProductListDTO {

    private String shopperId;
    private List<ProductShelfDTO> shelf;
}
