package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
    List<Carrinho> findAllByIdCarrinho(int idCarrinho);
}
