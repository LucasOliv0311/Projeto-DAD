package Repository;

import Model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByClienteId(Long clienteId); // Alterado o método para buscar cartões pelo id do cliente
}
