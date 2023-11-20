package com.senacre.ecommerce.cliente.endereco;

import com.senacre.ecommerce.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereços")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cep;
    private String logradouro;
    private int complemento;
    private String Bairro;
    private int numero;
    private String cidade;
    private String endereco;
    private boolean statusEndereco;
    private String enderecoPadrao;

    
    public Endereco(){}
    
    public Endereco(Long id, int cep, String logradouro, int complemento, String bairro, int numero, String cidade,
    String endereco, boolean statusEndereco, String enderecoPadrao) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        Bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.endereco = endereco;
        this.statusEndereco = statusEndereco;
        this.enderecoPadrao = enderecoPadrao;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isStatusEndereco() {
        return statusEndereco;
    }

    public void setStatusEndereco(boolean statusEndereco) {
        this.statusEndereco = statusEndereco;
    }

    public String getEnderecoPadrao() {
        return enderecoPadrao;
    }

    public void setEnderecoPadrao(String enderecoPadrao) {
        this.enderecoPadrao = enderecoPadrao;
    }

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;
}
