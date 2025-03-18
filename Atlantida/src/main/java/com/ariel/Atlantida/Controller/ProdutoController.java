package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.Service.ProdutoService;
import com.ariel.Atlantida.api.ProdutoApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController implements ProdutoApi {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @Override
    public ResponseEntity<Produto> buscarPorId(@PathVariable int idProduto) {
        Produto produto = produtoService.buscarPorId(idProduto);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @Override
    public ResponseEntity<Produto> atualizar(@PathVariable int idProduto, @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizar(idProduto, produto);
        return produtoAtualizado != null ? ResponseEntity.ok(produtoAtualizado) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deletar(@PathVariable int idProduto) {
        produtoService.deletar(idProduto);
        return ResponseEntity.noContent().build();
    }
}