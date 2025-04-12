package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.*;
import com.ariel.Atlantida.Repository.*;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, CarrinhoRepository carrinhoRepository,
                         CartaoRepository cartaoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    public PedidoDtoCreate criarPedido(PedidoDtoCreate pedidoDTO) {
        if (pedidoDTO.getIdCartao() == null) {
            throw new RuntimeException("O campo idCartao é obrigatório");
        }

        List<Carrinho> carrinhos = carrinhoRepository.findAllById(pedidoDTO.getIdCarrinho());

        if (carrinhos.size() != pedidoDTO.getIdCarrinho().size()) {
            throw new RuntimeException("Alguns produtos do carrinho não foram encontrados");
        }

        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = cartaoRepository.findById(pedidoDTO.getIdCartao())
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCarrinhos(carrinhos);
        pedido.setDataPedido(pedidoDTO.getDataPedido() != null ? pedidoDTO.getDataPedido() : LocalDateTime.now());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setIdCartao(cartao);
        pedido.setCliente(cliente);

        pedidoRepository.save(pedido);
        return toDto(pedido);
    }

    public PedidoDtoCreate buscarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return toDto(pedido);
    }

    public List<PedidoDtoCreate> listarPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PedidoDtoCreate atualizarPedido(int id, PedidoDtoCreate pedidoDTO) {
        if (pedidoDTO.getIdCartao() == null) {
            throw new RuntimeException("O campo idCartao é obrigatório");
        }

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        List<Carrinho> carrinhos = carrinhoRepository.findAllById(pedidoDTO.getIdCarrinho());

        if (carrinhos.size() != pedidoDTO.getIdCarrinho().size()) {
            throw new RuntimeException("Alguns produtos do carrinho não foram encontrados");
        }

        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = cartaoRepository.findById(pedidoDTO.getIdCartao())
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        pedido.setCarrinhos(carrinhos);
        pedido.setDataPedido(pedidoDTO.getDataPedido() != null ? pedidoDTO.getDataPedido() : LocalDateTime.now());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setIdCartao(cartao);
        pedido.setCliente(cliente);

        pedidoRepository.save(pedido);
        return toDto(pedido);
    }


    private PedidoDtoCreate toDto(Pedido pedido) {
        PedidoDtoCreate dto = new PedidoDtoCreate();

        List<Integer> idsCarrinho = pedido.getCarrinhos().stream()
                .map(Carrinho::getIdCarrinho)
                .collect(Collectors.toList());

        dto.setIdCarrinho(idsCarrinho);
        dto.setDataPedido(pedido.getDataPedido());
        dto.setValorTotal(pedido.getValorTotal());
        dto.setCliente(pedido.getCliente().getIdCliente());
        dto.setIdCartao(pedido.getIdCartao().getIdCartao());

        return dto;
    }
}
