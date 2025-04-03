package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(int idProduto) {
        return produtoRepository.findById((long) idProduto).orElse(null);
    }

    public List<Produto> buscarPorIds(List<Integer> idsProduto) {
        List<Long> idsLong = idsProduto.stream()
                .map(Long::valueOf)
                .toList();
        return produtoRepository.findAllByIdProdutoIn(idsLong);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(int idProduto, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById((long) idProduto);
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setTipo(produtoAtualizado.getTipo());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setEstoque(produtoAtualizado.getEstoque());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deletar(int idProduto) {
        produtoRepository.deleteById((long) idProduto);
    }
}
