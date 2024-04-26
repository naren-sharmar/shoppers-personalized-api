package com.shoppers.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Product {

    @Id
    private String productId;
    private String category;
    private String brand;
}