package com.ariel.Atlantida.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PedidoDtoResponse {

    private Integer idPedido;
    private LocalDate dataPedido;
    private BigDecimal valorTotal;
    private Integer idCartao;
    private Integer idCliente;
    private List<CarrinhoResumo> carrinhos;

    // Getters e setters...

    public static class CarrinhoResumo {
        private Integer idCarrinho;
        private Integer idProduto;
        private Integer quantidade;

        // Getters e setters

        public Integer getIdCarrinho() {
            return idCarrinho;
        }

        public void setIdCarrinho(Integer idCarrinho) {
            this.idCarrinho = idCarrinho;
        }

        public Integer getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(Integer idProduto) {
            this.idProduto = idProduto;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }
    }

    // Getters e setters do PedidoDtoResponse (fora da CarrinhoResumo)
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<CarrinhoResumo> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<CarrinhoResumo> carrinhos) {
        this.carrinhos = carrinhos;
    }
}
