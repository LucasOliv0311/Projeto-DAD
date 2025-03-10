package com.ariel.Atlantida.Repository;

import com.ariel.Atlantida.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    Optional<Cliente> findByCpf(String cpf);
}
