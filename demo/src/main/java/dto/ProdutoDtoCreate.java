package dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProdutoDtoCreate {
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(nullable = false, length = 100)
    private String tipo;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    @Column(nullable = false)
    private Integer estoque;
}
