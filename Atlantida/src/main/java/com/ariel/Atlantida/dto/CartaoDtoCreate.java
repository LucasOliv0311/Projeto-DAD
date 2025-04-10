package com.ariel.Atlantida.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CartaoDtoCreate {

    @Column(nullable = false, unique = true)
    private String numeroCartao;

    @Column(nullable = false)
    private LocalDate validade;

    @Column(nullable = false)
    private String cvv;

    @Column(nullable = false)
    private String bandeira;

    @Column(nullable = false)
    private String tipo;

    private int clienteId;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public int getClienteId() {return clienteId;}

    public void setClienteId(int clienteId) {this.clienteId = clienteId;}
}
