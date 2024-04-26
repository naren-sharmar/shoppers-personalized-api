package com.shoppers.api.repo;

import com.shoppers.api.entity.PersonalizedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalizedProductRepository extends JpaRepository<PersonalizedProduct, String> {

    List<PersonalizedProduct> findByShopperId(String shopperId);
}
