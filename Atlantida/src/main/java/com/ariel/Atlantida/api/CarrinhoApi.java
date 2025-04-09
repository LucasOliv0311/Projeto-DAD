package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
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
            @ApiResponse(responseCode = "400", description = "Erro ao adicionar item")
    })
    @PostMapping
    ResponseEntity<Carrinho> adicionar(@RequestBody CarrinhoDtoCreate dto);

    @Operation(summary = "Lista todos os itens do carrinho")
    @GetMapping
    ResponseEntity<List<Carrinho>> listar();

    @Operation(summary = "Busca um item do carrinho por ID")
    @GetMapping("/{id}")
    ResponseEntity<Carrinho> buscarPorId(@PathVariable("id") Long id);

    @Operation(summary = "Atualiza a quantidade de um item do carrinho")
    @PutMapping("/{id}/quantidade")
    ResponseEntity<Carrinho> atualizarQuantidade(@PathVariable("id") Long id, @RequestParam("quantidade") int quantidade);

    @Operation(summary = "Remove um item do carrinho")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> remover(@PathVariable("id") Long id);
}
