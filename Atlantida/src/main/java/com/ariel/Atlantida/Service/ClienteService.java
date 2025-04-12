package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Cliente;
import com.ariel.Atlantida.Repository.ClienteRepository;
import com.ariel.Atlantida.dto.ClienteDtoCreate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(ClienteDtoCreate clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setEndereco(clienteDTO.getEndereco());
        return clienteRepository.save(cliente);
    }

    public ClienteDtoCreate buscarCliente(int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return toDto(cliente);
    }

    public List<ClienteDtoCreate> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ClienteDtoCreate buscarClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return toDto(cliente);
    }

    public Cliente atualizarCliente(int idCliente, ClienteDtoCreate clienteDTO) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setEndereco(clienteDTO.getEndereco());
        return clienteRepository.save(cliente);
    }

    private ClienteDtoCreate toDto(Cliente cliente) {
        ClienteDtoCreate dto = new ClienteDtoCreate();
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        dto.setEndereco(cliente.getEndereco());
        return dto;
    }
}
