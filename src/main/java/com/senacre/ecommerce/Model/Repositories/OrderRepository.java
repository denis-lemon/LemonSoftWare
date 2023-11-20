package com.senacre.ecommerce.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senacre.ecommerce.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
