package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.Service.PedidoService;
import com.ariel.Atlantida.api.PedidoApi;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import com.ariel.Atlantida.dto.PedidoDtoResponse;
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
    public ResponseEntity<PedidoDtoResponse> buscarPedido(@PathVariable int id) {
        PedidoDtoResponse dto = pedidoService.buscarPedidoComCarrinhos(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<PedidoDtoResponse>> listarPedidos() {
        List<PedidoDtoResponse> pedidos = pedidoService.listarPedidosComCarrinhos();
        return ResponseEntity.ok(pedidos);
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
