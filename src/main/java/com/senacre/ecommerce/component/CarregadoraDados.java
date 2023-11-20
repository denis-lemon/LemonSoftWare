package com.senacre.ecommerce.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.senacre.ecommerce.Model.TipoUsuario;
import com.senacre.ecommerce.Model.Repositories.TipoRepository;

@Component
public class CarregadoraDados implements CommandLineRunner {

	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		String[] papeis = {"ADMIN", "USER", "BIBLIOTECARIO"};
		
		for (String papelString: papeis) {
			TipoUsuario papel = tipoRepository.findByTipo(papelString);
			if (papel == null) {
				papel = new TipoUsuario(papelString);
				tipoRepository.save(papel);
			}
		}				
	}

}
