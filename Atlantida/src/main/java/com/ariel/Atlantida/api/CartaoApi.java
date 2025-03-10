package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Cartao;
import com.ariel.Atlantida.dto.CartaoDtoCreate;
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

@RequestMapping("/cartoes")
@Tag(name = "Cartao")
public interface CartaoApi {

    @Operation(summary = "Cria um novo Cartão")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cartão criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o Cartão",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PostMapping
    ResponseEntity<Cartao> criarCartao(@RequestBody CartaoDtoCreate cartaoDtoCreate);

    @Operation(summary = "Busca um Cartão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartão encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class))),
            @ApiResponse(responseCode = "404", description = "Cartão não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @GetMapping("/{id}")
    ResponseEntity<Cartao> buscarCartao(@PathVariable("id") Long id);

    @Operation(summary = "Busca Cartões pelo ID do Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartões encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)))
    })
    @GetMapping("/cliente/{idCliente}")
    ResponseEntity<List<Cartao>> buscarCartoesPorCliente(@PathVariable("idCliente") Long idCliente);

    @Operation(summary = "Lista todos os Cartões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de Cartões recuperada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)))
    })
    @GetMapping
    ResponseEntity<List<Cartao>> listarCartoes();

    @Operation(summary = "Atualiza um Cartão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartão atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cartao.class))),
            @ApiResponse(responseCode = "404", description = "Cartão não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<Cartao> atualizarCartao(@PathVariable("id") Long id,
                                           @RequestBody CartaoDtoCreate cartaoDtoCreate);

    @Operation(summary = "Deleta um Cartão pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartão deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cartão não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarCartao(@PathVariable("id") Long id);
}
