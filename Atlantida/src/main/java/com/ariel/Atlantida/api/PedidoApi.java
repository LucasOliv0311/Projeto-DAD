package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pedidos")
@Tag(name = "Pedido", description = "API para gerenciamento de pedidos")
public interface PedidoApi {

    @Operation(summary = "Cria um novo Pedido", description = "Endpoint para criar um novo pedido com base nos dados fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o Pedido")
    })
    @PostMapping
    ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDtoCreate pedidoDtoCreate);

    @Operation(summary = "Busca um Pedido pelo ID", description = "Endpoint para recuperar um pedido específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<PedidoDtoCreate> buscarPedido(@PathVariable int id);

    @Operation(summary = "Lista todos os Pedidos", description = "Endpoint para listar todos os pedidos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos recuperada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class)))
    })
    @GetMapping
    ResponseEntity<List<PedidoDtoCreate>> listarPedidos();

    @Operation(summary = "Atualiza um Pedido pelo ID", description = "Endpoint para atualizar um pedido existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Pedido> atualizarPedido(@PathVariable int id, @RequestBody PedidoDtoCreate pedidoDtoCreate);

    @Operation(summary = "Deleta um Pedido pelo ID", description = "Endpoint para deletar um pedido específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarPedido(@PathVariable int id);
}
