package com.senacre.ecommerce.Model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senacre.ecommerce.Model.TipoUsuario;

public interface TipoRepository extends JpaRepository<TipoUsuario, Long>{
    TipoUsuario findByTipo(String tipo);
}
