package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.Service.PedidoService;
import com.ariel.Atlantida.api.PedidoApi;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController implements PedidoApi {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDtoCreate pedidoDTO) {
        return ResponseEntity.status(201).body(pedidoService.criarPedido(pedidoDTO));
    }

    @Override
    public ResponseEntity<Pedido> buscarPedido(@PathVariable int id) {
        return ResponseEntity.ok(pedidoService.buscarPedido(id));
    }

    @Override
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @Override
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable int id, @RequestBody PedidoDtoCreate pedidoDTO) {
        return ResponseEntity.ok(pedidoService.atualizarPedido(id, pedidoDTO));
    }

    @Override
    public ResponseEntity<Void> deletarPedido(@PathVariable int id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
