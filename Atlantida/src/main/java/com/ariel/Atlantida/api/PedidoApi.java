package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Pedido;
import com.ariel.Atlantida.dto.PedidoDtoCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pedidos")
@Tag(name = "Pedido", description = "Endpoints para gerenciamento de pedidos, incluindo criação, consulta, listagem e atualização.")
public interface PedidoApi {

    @Operation(
            summary = "Criar pedido",
            description = "Cria um novo pedido com base nas informações fornecidas no corpo da requisição."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Requisição malformada ou campos inválidos"),
            @ApiResponse(responseCode = "409", description = "Conflito: o pedido já existe ou contém dados conflitantes")
    })
    @PostMapping
    ResponseEntity<PedidoDtoCreate> criarPedido(@RequestBody PedidoDtoCreate pedidoDtoCreate);

    @Operation(
            summary = "Buscar pedido por ID",
            description = "Recupera um pedido específico pelo seu identificador único (ID)."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "404", description = "Pedido com o ID fornecido não foi encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<PedidoDtoCreate> buscarPedido(@PathVariable int id);

    @Operation(
            summary = "Listar todos os pedidos",
            description = "Retorna uma lista com todos os pedidos cadastrados no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Pedido.class))))
    })
    @GetMapping
    ResponseEntity<List<PedidoDtoCreate>> listarPedidos();

    @Operation(
            summary = "Atualizar pedido",
            description = "Atualiza as informações de um pedido existente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição"),
            @ApiResponse(responseCode = "404", description = "Pedido com o ID fornecido não foi encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<PedidoDtoCreate> atualizarPedido(@PathVariable int id, @RequestBody PedidoDtoCreate pedidoDtoCreate);
}
