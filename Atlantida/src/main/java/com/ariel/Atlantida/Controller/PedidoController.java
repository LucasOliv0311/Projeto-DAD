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
        Pedido pedido = pedidoService.criarPedido(pedidoDTO);
        return ResponseEntity.status(201).body(pedido);
    }

    @Override
    public ResponseEntity<PedidoDtoCreate> buscarPedido(@PathVariable int id) {
        PedidoDtoCreate dto = pedidoService.buscarPedido(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<PedidoDtoCreate>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @Override
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable int id, @RequestBody PedidoDtoCreate pedidoDTO) {
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoDTO);
        return ResponseEntity.ok(pedido);
    }

    @Override
    public ResponseEntity<Void> deletarPedido(@PathVariable int id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
