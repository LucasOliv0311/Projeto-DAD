package com.ariel.Atlantida.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao")
    private int idCartao;

    @Column(nullable = false, unique = true)
    private String numeroCartao;

    @Column(nullable = false)
    private Date validade;

    @Column(nullable = false)
    private String cvv;

    @Column(nullable = false)
    private String bandeira;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "id_cliente", nullable = false)
    private int idCliente;

    public int getIdCartao() {
        return idCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}