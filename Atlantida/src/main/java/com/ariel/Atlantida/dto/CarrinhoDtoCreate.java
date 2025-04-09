package com.ariel.Atlantida.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CarrinhoDtoCreate {

    @Column(nullable = false)
    private Long produtoId;

    @Column(nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private int quantidade;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
