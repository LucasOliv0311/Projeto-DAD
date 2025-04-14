package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.Service.CartaoService;
import com.ariel.Atlantida.api.CartaoApi;
import com.ariel.Atlantida.dto.CartaoDtoCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController implements CartaoApi {
    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @Override
    public ResponseEntity<Cartao> criarCartao(@RequestBody CartaoDtoCreate cartaoDTO) {
        return ResponseEntity.status(201).body(cartaoService.criarCartao(cartaoDTO));
    }

    @Override
    public ResponseEntity<Cartao> buscarCartao(@PathVariable int id) {
        return ResponseEntity.ok(cartaoService.buscarCartao(id));
    }

    @Override
    public ResponseEntity<List<Cartao>> buscarCartoesPorCliente(@PathVariable int clienteId) {
        return ResponseEntity.ok(cartaoService.buscarCartoesPorCliente(clienteId));
    }

    @Override
    public ResponseEntity<List<Cartao>> listarCartoes() {
        return ResponseEntity.ok(cartaoService.listarCartoes());
    }

    @Override
    public ResponseEntity<Cartao> atualizarCartao(@PathVariable int id, @RequestBody CartaoDtoCreate cartaoDTO) {
        return ResponseEntity.ok(cartaoService.atualizarCartao(id, cartaoDTO));
    }
}
