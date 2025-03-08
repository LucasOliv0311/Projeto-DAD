package Repository;

import Model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao,Integer>{
    List<Cartao> findByIdCliente(Long idCliente);
}
