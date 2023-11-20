package com.senacre.ecommerce.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipoUser")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Papel - oque usuario irá fazer no sistema

    /*
     * Relacionamento de Tipo de Usuario e Usuario - Muitos Tipos de Usuarios para
     * muitos Usuaarios
     */
    @ManyToMany(mappedBy = "tipoUsuarios", fetch = FetchType.EAGER)
    private List<Usuario> usuario;

    
    public TipoUsuario(){       
    }
    
    public TipoUsuario(String tipo) {
        super();
        this.tipo = tipo;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }
}