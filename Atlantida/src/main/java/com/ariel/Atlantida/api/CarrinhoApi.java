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

@RequestMapping("/carrinhos")
@Tag(name = "Carrinho")
public interface CarrinhoApi {

    @Operation(summary = "Cria um novo Carrinho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrinho criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o Carrinho",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PostMapping
    ResponseEntity<Carrinho> criarCarrinho(@RequestBody CarrinhoDtoCreate carrinhoDtoCreate);

    @Operation(summary = "Busca um Carrinho pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @GetMapping("/{id}")
    ResponseEntity<Carrinho> buscarCarrinho(@PathVariable("id") int id);

    @Operation(summary = "Lista todos os Carrinhos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de Carrinhos recuperada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)))
    })
    @GetMapping
    ResponseEntity<List<Carrinho>> listarCarrinhos();

    @Operation(summary = "Atualiza um Carrinho pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable("id") int id,
                                               @RequestBody CarrinhoDtoCreate carrinhoDtoCreate);

    @Operation(summary = "Deleta um Carrinho pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarCarrinho(@PathVariable("id") int id);
}
