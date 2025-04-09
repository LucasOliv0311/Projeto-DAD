package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
import io.netty.channel.unix.Errors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/carrinho")
@Tag(name = "Carrinho", description = "API para manipulação dos itens no carrinho")
public interface CarrinhoApi {

    @Operation(summary = "Adiciona um item ao carrinho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item adicionado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar item",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PostMapping
    ResponseEntity<Carrinho> adicionar(@RequestBody CarrinhoDtoCreate dto);

    @Operation(summary = "Lista todos os itens do carrinho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Itens listados com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class)))
    })
    @GetMapping
    ResponseEntity<List<Carrinho>> listar();

    @Operation(summary = "Busca um item do carrinho por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "404", description = "Item não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @GetMapping("/{id}")
    ResponseEntity<Carrinho> buscarPorId(@PathVariable("id") Long id);

    @Operation(summary = "Atualiza a quantidade de um item do carrinho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quantidade atualizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "404", description = "Item não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PutMapping("/{id}/quantidade")
    ResponseEntity<Carrinho> atualizarQuantidade(@PathVariable("id") Long id, @RequestParam("quantidade") int quantidade);

    @Operation(summary = "Remove um item do carrinho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> remover(@PathVariable("id") Long id);
}

