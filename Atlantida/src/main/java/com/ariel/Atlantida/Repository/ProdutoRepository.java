package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
