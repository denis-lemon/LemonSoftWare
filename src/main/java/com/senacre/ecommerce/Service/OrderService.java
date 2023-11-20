package com.senacre.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senacre.ecommerce.Model.Order;
import com.senacre.ecommerce.Model.Repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
      Optional<Order> obj = repository.findById(id);
      return obj.get();
    }

    public Order insert(Order obj) {
      return repository.save(obj);
    }

    
}
