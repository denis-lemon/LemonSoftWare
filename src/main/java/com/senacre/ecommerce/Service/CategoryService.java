package com.senacre.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senacre.ecommerce.Model.Categoria;
import com.senacre.ecommerce.Model.Repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Long id){
      Optional<Categoria> obj = repository.findById(id);
      return obj.get();
    }

    
}
