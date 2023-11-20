package com.senacre.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senacre.ecommerce.Model.TipoUsuario;
import com.senacre.ecommerce.Model.Repositories.TipoRepository;

@Service
public class TipoServiceImp implements TipoService{

    @Autowired
	private TipoRepository tipoRepository;

    @Override
    public TipoUsuario buscarTipoPorId(Long id) {
        Optional<TipoUsuario> opt = tipoRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new IllegalArgumentException("Papel com id : " + id + " não existe");
		}
    }

    @Override
    public TipoUsuario buscarTipo(String tipo) {
        TipoUsuario tp = tipoRepository.findByTipo(tipo);
		return tp;
    }

    @Override
    public List<TipoUsuario> listarTipo() {
        List<TipoUsuario> tipos = tipoRepository.findAll();
		return tipos;
    }
    
}