package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.Model.Cliente;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import com.ariel.Atlantida.Repository.PedidoRepository;
import com.ariel.Atlantida.Repository.ProdutoRepository;
import com.ariel.Atlantida.Repository.CartaoRepository;
import com.ariel.Atlantida.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository,
                         CartaoRepository cartaoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Pedido criarPedido(PedidoDtoCreate pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = (pedidoDTO.getIdCartao() != null)
                ? cartaoRepository.findById(pedidoDTO.getIdCartao()).orElse(null)
                : null;

        Pedido pedido = new Pedido();
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setIdCartao(cartao);
        pedido.setCliente(cliente);

        return pedidoRepository.save(pedido);
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

    public Pedido atualizarPedido(int id, PedidoDtoCreate pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = (pedidoDTO.getIdCartao() != null)
                ? cartaoRepository.findById(pedidoDTO.getIdCartao()).orElse(null)
                : null;

        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setCliente(cliente);
        pedido.setIdCartao(cartao);

        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
    }

    private PedidoDtoCreate toDto(Pedido pedido) {
        PedidoDtoCreate dto = new PedidoDtoCreate();

        dto.setDataPedido(pedido.getDataPedido());
        dto.setValorTotal(pedido.getValorTotal());
        dto.setCliente(pedido.getCliente().getIdCliente());

        if (pedido.getIdCartao() != null) {
            dto.setIdCartao(pedido.getIdCartao().getIdCartao());
        }

        return dto;
    }
}
