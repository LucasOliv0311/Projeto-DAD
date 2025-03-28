package com.ariel.Atlantida.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


import com.ariel.Atlantida.Model.Produto;
import lombok.Data;

@Data
public class PedidoDtoCreate {
    private Integer idProduto;
    private LocalDateTime dataPedido;
    private BigDecimal valorTotal;
    private Integer idCartao;
    private int idCliente;

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

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}