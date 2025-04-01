package com.ariel.Atlantida.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


import com.ariel.Atlantida.Model.Produto;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class PedidoDtoCreate {
    private JsonNode idProduto;
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

    public JsonNode getIdProduto() {return idProduto;}

    public void setIdProduto(JsonNode idProduto) {this.idProduto = idProduto;}

    public int getIdCliente() {return idCliente;}

    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
}