package dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CartaoDtoCreate {

    @Column(nullable = false, unique = true, length = 16)
    private String numeroCartao;

    @Column(nullable = false)
    private LocalDate validade;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Column(nullable = false, length = 50)
    private String bandeira;

    @Column(nullable = false, length = 10)
    private String tipo;

    private Long idCliente; // Alterado para Long para corresponder ao tipo da entidade Cliente
}
