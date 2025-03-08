package dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClienteDtoCreate {
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Column(unique = true, length = 100)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String endereco;
}
