package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.Service.CarrinhoService;
import com.ariel.Atlantida.api.CarrinhoApi;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarrinhoController implements CarrinhoApi {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @Override
    public ResponseEntity<Carrinho> criarCarrinho(CarrinhoDtoCreate carrinhoDtoCreate) {
        Carrinho carrinho = carrinhoService.criarCarrinho(carrinhoDtoCreate);
        return ResponseEntity.status(201).body(carrinho);
    }

    @Override
    public ResponseEntity<Carrinho> buscarCarrinho(int id) {
        Carrinho carrinho = carrinhoService.buscarCarrinho(id);
        return ResponseEntity.ok(carrinho);
    }

    @Override
    public ResponseEntity<List<Carrinho>> listarCarrinhos() {
        List<Carrinho> carrinhos = carrinhoService.listarCarrinhos();
        return ResponseEntity.ok(carrinhos);
    }

    @Override
    public ResponseEntity<Carrinho> atualizarCarrinho(int id, CarrinhoDtoCreate carrinhoDtoCreate) {
        Carrinho carrinhoAtualizado = carrinhoService.atualizarCarrinho(id, carrinhoDtoCreate);
        return ResponseEntity.ok(carrinhoAtualizado);
    }

    @Override
    public ResponseEntity<Void> deletarCarrinho(int id) {
        carrinhoService.deletarCarrinho(id);
        return ResponseEntity.noContent().build();
    }
}
