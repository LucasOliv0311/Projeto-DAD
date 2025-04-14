package com.ariel.Atlantida.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDtoCreate {
    private List<Integer> idCarrinho;
    private LocalDateTime dataPedido;
    private BigDecimal valorTotal;
    private Integer idCartao; // agora é obrigatório, verificado no service
    private Integer cliente;
}
