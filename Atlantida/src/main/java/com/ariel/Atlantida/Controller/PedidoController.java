package com.ariel.Atlantida.Controller;

import com.ariel.Atlantida.Service.PedidoService;
import com.ariel.Atlantida.api.PedidoApi;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController implements PedidoApi {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public ResponseEntity<PedidoDtoCreate> criarPedido(@RequestBody PedidoDtoCreate pedidoDtoCreate) {
        PedidoDtoCreate criado = pedidoService.criarPedido(pedidoDtoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @Override
    public ResponseEntity<PedidoDtoCreate> buscarPedido(@PathVariable int id) {
        PedidoDtoCreate pedido = pedidoService.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @Override
    public ResponseEntity<List<PedidoDtoCreate>> listarPedidos() {
        List<PedidoDtoCreate> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @Override
    public ResponseEntity<PedidoDtoCreate> atualizarPedido(@PathVariable int id, @RequestBody PedidoDtoCreate pedidoDtoCreate) {
        PedidoDtoCreate atualizado = pedidoService.atualizarPedido(id, pedidoDtoCreate);
        return ResponseEntity.ok(atualizado);
    }
}
