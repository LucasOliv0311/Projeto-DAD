package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.dto.CartaoDtoCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cartoes")
@Tag(name = "Cartao", description = "Operações relacionadas ao recurso Cartão")
public interface CartaoApi {

    @Operation(summary = "Cria um novo cartão")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cartão criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o cartão")
    })
    @PostMapping
    ResponseEntity<Cartao> criarCartao(@RequestBody CartaoDtoCreate cartaoDtoCreate);

    @Operation(summary = "Busca um cartão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartão encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class))),
            @ApiResponse(responseCode = "404", description = "Cartão não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Cartao> buscarCartao(@PathVariable int id);

    @Operation(summary = "Busca cartões pelo ID do cliente")
    @ApiResponse(responseCode = "200", description = "Cartões encontrados",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class)))
    @GetMapping("/cliente/{idCliente}")
    ResponseEntity<List<Cartao>> buscarCartoesPorCliente(@PathVariable int idCliente);

    @Operation(summary = "Lista todos os cartões")
    @ApiResponse(responseCode = "200", description = "Lista de cartões recuperada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class)))
    @GetMapping
    ResponseEntity<List<Cartao>> listarCartoes();

    @Operation(summary = "Atualiza um cartão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartão atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class))),
            @ApiResponse(responseCode = "404", description = "Cartão não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Cartao> atualizarCartao(@PathVariable int id,
                                           @RequestBody CartaoDtoCreate cartaoDtoCreate);
}
