package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.dto.ProdutoDtoCreate;
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

@RequestMapping("/produto")
@Tag(name = "Produto")
public interface ProdutoApi {
    @Operation(summary = "Lista todos os Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de Produtos recuperada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)))
    })
    @GetMapping
    ResponseEntity<List<Produto>> listarTodos();

    @Operation(summary = "Busca um Produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @GetMapping("/{idProduto}")
    ResponseEntity<Produto> buscarPorId(@PathVariable("idProduto") int idProduto);

    @Operation(summary = "Salva um novo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto salvo com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao salvar o Produto",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PostMapping
    ResponseEntity<Produto> salvar(@RequestBody Produto produto);

    @Operation(summary = "Atualiza um Produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PutMapping("/{idProduto}")
    ResponseEntity<Produto> atualizar(@PathVariable("idProduto") int idProduto,
                                      @RequestBody Produto produto);

    @Operation(summary = "Deleta um Produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @DeleteMapping("/{idProduto}")
    ResponseEntity<Void> deletar(@PathVariable("idProduto") int idProduto);
}
