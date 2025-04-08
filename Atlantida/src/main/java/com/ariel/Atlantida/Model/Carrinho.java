package com.ariel.Atlantida.Model;

import jakarta.persistence.*;

public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho")
    private int idCarrinho;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;

    @ManyToMany
    @JoinColumn(name = "id_produto")
    private Pedido idProduto;

}
