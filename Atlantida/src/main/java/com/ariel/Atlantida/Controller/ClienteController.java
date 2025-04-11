package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Cliente;
import com.ariel.Atlantida.Service.ClienteService;
import com.ariel.Atlantida.api.ClienteApi;
import com.ariel.Atlantida.dto.ClienteDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements ClienteApi {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody ClienteDtoCreate clienteDtoCreate) {
        Cliente cliente = clienteService.criarCliente(clienteDtoCreate);
        return ResponseEntity.status(201).body(cliente);
    }

    @Override
    public ResponseEntity<ClienteDtoCreate> buscarCliente(@PathVariable int idCliente) {
        ClienteDtoCreate cliente = clienteService.buscarCliente(idCliente);
        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<List<ClienteDtoCreate>> listarClientes() {
        List<ClienteDtoCreate> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<ClienteDtoCreate> buscarClientePorCpf(@PathVariable String cpf) {
        ClienteDtoCreate cliente = clienteService.buscarClientePorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable int idCliente,
                                                    @Valid @RequestBody ClienteDtoCreate clienteDtoCreate) {
        Cliente cliente = clienteService.atualizarCliente(idCliente, clienteDtoCreate);
        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<Void> deletarCliente(@PathVariable int idCliente) {
        clienteService.deletarCliente(idCliente);
        return ResponseEntity.noContent().build();
    }
}
