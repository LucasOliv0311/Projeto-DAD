package com.ariel.Atlantida.Model;

import jakarta.persistence.*;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrinho;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto id_produto;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido id_pedido;

    private int quantidade_produtos;

    // Getters e setters


    public Integer getId_carrinho() {
        return Math.toIntExact(id_carrinho);
    }

    public void setId_carrinho(Long id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getQuantidade_produtos() {
        return quantidade_produtos;
    }

    public void setQuantidade_produtos(int quantidade_produtos) {
        this.quantidade_produtos = quantidade_produtos;
    }
}

