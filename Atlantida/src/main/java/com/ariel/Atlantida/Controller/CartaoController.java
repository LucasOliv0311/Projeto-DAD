package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.Service.CartaoService;
import com.ariel.Atlantida.api.CartaoApi;
import com.ariel.Atlantida.dto.CartaoDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController implements CartaoApi {

    @Autowired
    private CartaoService cartaoService;

    @Override
    public ResponseEntity<Cartao> criarCartao(@RequestBody CartaoDtoCreate cartaoDTO) {
        Cartao cartao = cartaoService.criarCartao(cartaoDTO);
        return ResponseEntity.status(201).body(cartao);
    }

    @Override
    public ResponseEntity<Cartao> buscarCartao(@PathVariable Long id) {
        Cartao cartao = cartaoService.buscarCartao(id);
        return cartao != null ? ResponseEntity.ok(cartao) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Cartao>> buscarCartoesPorCliente(@PathVariable Long clienteId) {
        List<Cartao> cartoes = cartaoService.buscarCartoesPorCliente(Math.toIntExact(clienteId));
        return ResponseEntity.ok(cartoes);
    }

    @Override
    public ResponseEntity<List<Cartao>> listarCartoes() {
        List<Cartao> cartoes = cartaoService.listarCartoes();
        return ResponseEntity.ok(cartoes);
    }

    @Override
    public ResponseEntity<Cartao> atualizarCartao(@PathVariable Long id, @RequestBody CartaoDtoCreate cartaoDTO) {
        Cartao cartao = cartaoService.atualizarCartao(id, cartaoDTO);
        return cartao != null ? ResponseEntity.ok(cartao) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deletarCartao(@PathVariable Long id) {
        cartaoService.deletarCartao(id);
        return ResponseEntity.noContent().build();
    }
}
