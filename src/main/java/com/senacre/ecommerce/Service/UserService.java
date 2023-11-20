package com.senacre.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senacre.ecommerce.Model.Usuario;
import com.senacre.ecommerce.Model.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(Long id){
      Optional<Usuario> obj = repository.findById(id);
      return obj.get();
    }

    public Usuario insert(Usuario obj) {
      return repository.save(obj);
    }
    
}
