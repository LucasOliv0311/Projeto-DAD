package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
