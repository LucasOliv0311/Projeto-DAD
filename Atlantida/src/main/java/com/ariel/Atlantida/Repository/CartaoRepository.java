package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByClienteId(Long clienteId);
}
