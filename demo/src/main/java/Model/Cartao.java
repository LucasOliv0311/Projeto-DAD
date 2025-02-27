package Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}
