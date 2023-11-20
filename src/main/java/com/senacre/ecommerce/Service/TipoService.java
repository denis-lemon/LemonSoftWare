package com.senacre.ecommerce.Service;

import java.util.List;

import com.senacre.ecommerce.Model.TipoUsuario;

public interface TipoService {
    public TipoUsuario buscarTipoPorId(Long id);
	public TipoUsuario buscarTipo(String tipo);
	public List<TipoUsuario> listarTipo();
}
