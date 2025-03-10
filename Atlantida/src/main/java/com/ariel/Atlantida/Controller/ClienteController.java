package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Cliente;
import com.ariel.Atlantida.Service.ClienteService;
import com.ariel.Atlantida.api.ClienteApi;
import com.ariel.Atlantida.dto.ClienteDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements ClienteApi {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDtoCreate clienteDTO) {
        Cliente cliente = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.status(201).body(cliente);
    }

    @Override
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) {
        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDtoCreate clienteDTO) {
        Cliente cliente = clienteService.atualizarCliente(id, clienteDTO);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
