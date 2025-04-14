package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Repository.CarrinhoRepository;
import com.ariel.Atlantida.Repository.ProdutoRepository;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    public Carrinho criarCarrinho(CarrinhoDtoCreate dto) {
        Produto produto = produtoRepository.findById(Long.valueOf(dto.getIdProduto()))
                .orElseThrow(() -> new RuntimeException("Produto com ID " + dto.getIdProduto() + " não encontrado"));

        Carrinho carrinho = new Carrinho();
        carrinho.setIdProduto(produto);
        carrinho.setQuantidade(dto.getQuantidade());

        return carrinhoRepository.save(carrinho);
    }

    public Carrinho buscarCarrinho(int idCarrinho) {
        return carrinhoRepository.findById(idCarrinho)
                .orElseThrow(() -> new RuntimeException("Carrinho com ID " + idCarrinho + " não encontrado"));
    }

    public List<Carrinho> listarCarrinhos() {
        return carrinhoRepository.findAll();
    }

    public Carrinho atualizarCarrinho(int idCarrinho, CarrinhoDtoCreate dto) {
        Carrinho carrinho = buscarCarrinho(idCarrinho);

        Produto produto = produtoRepository.findById(Long.valueOf(dto.getIdProduto()))
                .orElseThrow(() -> new RuntimeException("Produto com ID " + dto.getIdProduto() + " não encontrado"));

        carrinho.setIdProduto(produto);
        carrinho.setQuantidade(dto.getQuantidade());

        return carrinhoRepository.save(carrinho);
    }

    public void deletarCarrinho(int idCarrinho) {
        Carrinho carrinho = buscarCarrinho(idCarrinho);
        carrinhoRepository.delete(carrinho);
    }
}
