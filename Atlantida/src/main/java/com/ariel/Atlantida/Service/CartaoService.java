package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.Model.Cliente;
import com.ariel.Atlantida.dto.CartaoDtoCreate;
import com.ariel.Atlantida.Repository.CartaoRepository;
import com.ariel.Atlantida.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    private final ClienteRepository clienteRepository;

    public CartaoService(CartaoRepository cartaoRepository, ClienteRepository clienteRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Cartao criarCartao(CartaoDtoCreate cartaoDTO) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(cartaoDTO.getIdCliente()))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setTipo(cartaoDTO.getTipo());
        cartao.setIdCliente(cliente);

        return cartaoRepository.save(cartao);
    }

    public Cartao buscarCartao(Long id) {
        return cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
    }

    public List<Cartao> buscarCartoesPorCliente(int clienteId) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return cartaoRepository.findByClienteId((long) cliente.getIdCliente());
    }

    public List<Cartao> listarCartoes() {
        return cartaoRepository.findAll();
    }

    public Cartao atualizarCartao(Long id, CartaoDtoCreate cartaoDTO) {
        Cartao cartao = buscarCartao(id);

        Cliente cliente = clienteRepository.findById(Math.toIntExact(cartaoDTO.getIdCliente()))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setTipo(cartaoDTO.getTipo());
        cartao.setIdCliente(cliente);

        return cartaoRepository.save(cartao);
    }

    public void deletarCartao(Long id) {
        Cartao cartao = buscarCartao(id);
        cartaoRepository.delete(cartao);
    }
}
