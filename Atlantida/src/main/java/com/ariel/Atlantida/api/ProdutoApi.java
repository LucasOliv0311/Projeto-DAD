package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Produto;
import com.ariel.Atlantida.dto.ProdutoDtoCreate;
import io.netty.channel.unix.Errors;
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

@RequestMapping("/produto")
@Tag(name = "Produto", description = "Endpoints para gerenciamento de produtos, incluindo listagem, criação, atualização e exclusão.")
public interface ProdutoApi {

    @Operation(
            summary = "Listar todos os Produtos",
            description = "Recupera a lista completa de todos os produtos cadastrados no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos recuperada com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Produto.class))))
    })
    @GetMapping
    ResponseEntity<List<Produto>> listarTodos();

    @Operation(
            summary = "Buscar Produto por ID",
            description = "Recupera um produto específico através do seu identificador único (ID)."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado com o ID fornecido",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @GetMapping("/{idProduto}")
    ResponseEntity<Produto> buscarPorId(@PathVariable("idProduto") int idProduto);

    @Operation(
            summary = "Salvar um novo Produto",
            description = "Cria um novo produto no sistema com base nos dados fornecidos no corpo da requisição."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o produto (por exemplo, dados duplicados)",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PostMapping
    ResponseEntity<Produto> salvar(@RequestBody Produto produto);

    @Operation(
            summary = "Atualizar Produto por ID",
            description = "Atualiza as informações de um produto existente no sistema com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto com o ID fornecido não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PutMapping("/{idProduto}")
    ResponseEntity<Produto> atualizar(@PathVariable("idProduto") int idProduto, @RequestBody Produto produto);

    @Operation(
            summary = "Deletar Produto por ID",
            description = "Remove um produto do sistema com base no seu ID único."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado com o ID fornecido",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @DeleteMapping("/{idProduto}")
    ResponseEntity<Void> deletar(@PathVariable("idProduto") int idProduto);
}
