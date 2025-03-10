package Service;

import Model.Pedido;
import Model.Produto;
import Repository.PedidoRepository;
import Repository.ProdutoRepository;
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

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(Math.toIntExact(id));
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setId(produtoAtualizado.getId());
            produto.setNome(produtoAtualizado.getNome());
            produto.setTipo(produtoAtualizado.getTipo());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setEstoque(produtoAtualizado.getEstoque());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(Math.toIntExact(id));
    }
}
