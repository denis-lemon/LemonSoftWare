package com.senacre.ecommerce.carrinhodecompra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.senacre.ecommerce.cliente.Cliente;
import com.senacre.ecommerce.cliente.endereco.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CarrinhoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

     @ManyToMany
    @JoinTable(name = "carrinho_estoque",
        joinColumns = @JoinColumn(name = "carrinho_id"),
        inverseJoinColumns = @JoinColumn(name = "estoque_id"))
    private List<Estoque> estoques = new ArrayList<>();

    private Integer quantidade;

    private BigDecimal preco;

    @ManyToOne
    private Cliente cliente;

    private BigDecimal frete;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    private Long codigoPedido;
}
