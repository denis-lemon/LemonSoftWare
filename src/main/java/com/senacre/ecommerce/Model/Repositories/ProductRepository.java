package com.senacre.ecommerce.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senacre.ecommerce.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
