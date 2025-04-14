package com.ariel.Atlantida.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho")
    private int idCarrinho;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto idProduto;

    @JoinColumn(name = "quantidade")
    private int quantidade;
}
