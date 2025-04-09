package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.Service.CarrinhoService;
import com.ariel.Atlantida.api.CarrinhoApi;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController implements CarrinhoApi {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @Override
    public ResponseEntity<Carrinho> adicionar(@RequestBody CarrinhoDtoCreate dto) {
        return ResponseEntity.status(201).body(carrinhoService.adicionarAoCarrinho(dto));
    }

    @Override
    public ResponseEntity<List<Carrinho>> listar() {
        return ResponseEntity.ok(carrinhoService.listarTodos());
    }

    @Override
    public ResponseEntity<Carrinho> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.buscarPorId(id));
    }

    @Override
    public ResponseEntity<Carrinho> atualizarQuantidade(@PathVariable Long id, @RequestParam int quantidade) {
        return ResponseEntity.ok(carrinhoService.atualizarQuantidade(id, quantidade));
    }

    @Override
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        carrinhoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
