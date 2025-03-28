package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Cartao;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    List<Cartao> findByIdCliente_IdCliente(int idCliente);
}