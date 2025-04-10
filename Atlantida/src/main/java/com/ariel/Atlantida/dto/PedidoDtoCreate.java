package com.ariel.Atlantida.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


import lombok.Data;

@Data
public class PedidoDtoCreate {
    private List<Integer> idProduto;
    private LocalDateTime dataPedido;
    private BigDecimal valorTotal;
    private Integer idCartao;
    private Integer cliente;

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public int getCliente() {return cliente;}

    public void setCliente(int cliente) {this.cliente = cliente;}


    public void setIdProduto(List<Integer> idProduto) {
        this.idProduto = idProduto;
    }
}