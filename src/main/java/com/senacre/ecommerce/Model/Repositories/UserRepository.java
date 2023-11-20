package com.senacre.ecommerce.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senacre.ecommerce.Model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    
}
