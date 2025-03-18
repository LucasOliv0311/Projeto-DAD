package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import com.ariel.Atlantida.Repository.PedidoRepository;
import com.ariel.Atlantida.Repository.ProdutoRepository;
import com.ariel.Atlantida.Repository.CartaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final CartaoRepository cartaoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, CartaoRepository cartaoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    public Pedido criarPedido(PedidoDtoCreate pedidoDTO) {
        Produto produto = (Produto) produtoRepository.findById(pedidoDTO.getIdProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Cartao cartao = (pedidoDTO.getIdCartao() != null) ?
                cartaoRepository.findById(pedidoDTO.getIdCartao()).orElse(null) : null;

        Pedido pedido = new Pedido();
        pedido.setIdProduto(produto);
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setIdCartao(cartao);

        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPedido(int id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido atualizarPedido(int id, PedidoDtoCreate pedidoDTO) {
        Pedido pedido = buscarPedido(id);
        Produto produto = (Produto) produtoRepository.findById(pedidoDTO.getIdProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Cartao cartao = (pedidoDTO.getIdCartao() != null) ?
                cartaoRepository.findById(pedidoDTO.getIdCartao()).orElse(null) : null;

        pedido.setIdProduto(produto);
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setIdCartao(cartao);

        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(int id) {
        Pedido pedido = buscarPedido(id);
        pedidoRepository.delete(pedido);
    }
}
