package dto;

import Model.Cartao;
import Model.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoDtoCreate {
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataPedido;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "id_cartao")
    private Cartao cartao;
}
