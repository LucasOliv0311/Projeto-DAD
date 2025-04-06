package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByIdProdutoIn(List<Long> idProdutos);
}
