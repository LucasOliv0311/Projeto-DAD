package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.Repository.CartaoRepository;
import com.ariel.Atlantida.Repository.ClienteRepository;
import com.ariel.Atlantida.dto.CartaoDtoCreate;
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
        if (!clienteRepository.existsById(cartaoDTO.getClienteId())) {
            throw new RuntimeException("Cliente com ID " + cartaoDTO.getClienteId() + " não encontrado");
        }

        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setTipo(cartaoDTO.getTipo());
        cartao.setIdCliente(cartaoDTO.getClienteId());

        return cartaoRepository.save(cartao);
    }

    public Cartao buscarCartao(int id) {
        return cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão com ID " + id + " não encontrado"));
    }

    public List<Cartao> buscarCartoesPorCliente(int clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            throw new RuntimeException("Cliente com ID " + clienteId + " não encontrado");
        }
        return cartaoRepository.findByIdCliente(clienteId);
    }

    public List<Cartao> listarCartoes() {
        return cartaoRepository.findAll();
    }

    public Cartao atualizarCartao(int id, CartaoDtoCreate cartaoDTO) {
        Cartao cartao = buscarCartao(id);

        if (!clienteRepository.existsById(cartaoDTO.getClienteId())) {
            throw new RuntimeException("Cliente com ID " + cartaoDTO.getClienteId() + " não encontrado");
        }

        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setTipo(cartaoDTO.getTipo());
        cartao.setIdCliente(cartaoDTO.getClienteId());

        return cartaoRepository.save(cartao);
    }

}
