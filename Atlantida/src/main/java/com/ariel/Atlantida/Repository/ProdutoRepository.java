package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findById(Integer idProduto);
}
