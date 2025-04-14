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

@RequestMapping("/carrinhos")
@Tag(name = "Carrinho", description = "Operações relacionadas ao recurso Carrinho")
public interface CarrinhoApi {

    @Operation(summary = "Cria um novo carrinho")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrinho criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o carrinho")
    })
    @PostMapping
    ResponseEntity<Carrinho> criarCarrinho(@RequestBody CarrinhoDtoCreate carrinhoDtoCreate);

    @Operation(summary = "Busca um carrinho pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Carrinho> buscarCarrinho(@PathVariable int id);

    @Operation(summary = "Lista todos os carrinhos")
    @ApiResponse(responseCode = "200", description = "Lista de carrinhos recuperada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class)))
    @GetMapping
    ResponseEntity<List<Carrinho>> listarCarrinhos();

    @Operation(summary = "Atualiza um carrinho pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Carrinho.class))),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable int id,
                                               @RequestBody CarrinhoDtoCreate carrinhoDtoCreate);

    @Operation(summary = "Deleta um carrinho pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carrinho deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carrinho não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarCarrinho(@PathVariable int id);
}
