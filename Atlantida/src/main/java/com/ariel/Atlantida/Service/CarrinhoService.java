package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Repository.CarrinhoRepository;
import com.ariel.Atlantida.Repository.PedidoRepository;
import com.ariel.Atlantida.Repository.ProdutoRepository;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Carrinho adicionarAoCarrinho(CarrinhoDtoCreate dto) {
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Pedido pedido = pedidoRepository.findById(Math.toIntExact(dto.getPedidoId()))
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (produto.getEstoque() < dto.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        Carrinho carrinho = new Carrinho();
        carrinho.setId_produto(produto);
        carrinho.setId_pedido(pedido);
        carrinho.setQuantidade_produtos(dto.getQuantidade());

        produto.setEstoque(produto.getEstoque() - dto.getQuantidade());
        produtoRepository.save(produto);

        return carrinhoRepository.save(carrinho);
    }

    public List<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho buscarPorId(Long id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do carrinho não encontrado"));
    }

    public void remover(Long id) {
        Carrinho carrinho = buscarPorId(id);

        Produto produto = carrinho.getId_produto();
        produto.setEstoque(produto.getEstoque() + carrinho.getQuantidade_produtos());
        produtoRepository.save(produto);

        carrinhoRepository.deleteById(id);
    }

    public Carrinho atualizarQuantidade(Long id, int novaQuantidade) {
        Carrinho carrinho = buscarPorId(id);
        Produto produto = carrinho.getId_produto();

        int quantidadeAtual = carrinho.getQuantidade_produtos();
        int diferenca = novaQuantidade - quantidadeAtual;

        if (diferenca > 0) {
            if (produto.getEstoque() < diferenca) {
                throw new RuntimeException("Estoque insuficiente para aumentar a quantidade");
            }
            produto.setEstoque(produto.getEstoque() - diferenca);
        } else if (diferenca < 0) {
            produto.setEstoque(produto.getEstoque() + Math.abs(diferenca));
        }

        carrinho.setQuantidade_produtos(novaQuantidade);
        produtoRepository.save(produto);

        return carrinhoRepository.save(carrinho);
    }
}
