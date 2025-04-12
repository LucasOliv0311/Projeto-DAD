package com.ariel.Atlantida.Service;

import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    private static final Pattern IMAGEM_REGEX = Pattern.compile("(?i).+\\.(jpg|jpeg|png)$");

    private boolean isImagemValida(String imagem) {
        return imagem != null && IMAGEM_REGEX.matcher(imagem).matches();
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(int idProduto) {
        return produtoRepository.findById((long) idProduto).orElse(null);
    }

    public Produto salvar(Produto produto) {
        if (!isImagemValida(produto.getImagem())) {
            throw new IllegalArgumentException("Imagem inválida. Deve ser um arquivo com extensão .jpg, .jpeg, .png, .gif ou .bmp.");
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizar(int idProduto, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById((long) idProduto);
        if (produtoExistente.isPresent()) {
            if (!isImagemValida(produtoAtualizado.getImagem())) {
                throw new IllegalArgumentException("Imagem inválida. Deve ser um arquivo com extensão .jpg, .jpeg ou .png.");
            }
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setTipo(produtoAtualizado.getTipo());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setEstoque(produtoAtualizado.getEstoque());
            produto.setImagem(produtoAtualizado.getImagem());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deletar(int idProduto) {
        produtoRepository.deleteById((long) idProduto);
    }
}
