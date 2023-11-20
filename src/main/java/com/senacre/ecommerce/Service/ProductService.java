package com.senacre.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senacre.ecommerce.Model.Product;
import com.senacre.ecommerce.Model.Repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
      Optional<Product> obj = repository.findById(id);
      return obj.get();
    }

    public Product insert(Product obj) {
      return repository.save(obj);
    }

    
}
