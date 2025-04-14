package com.ariel.Atlantida.api;

import com.ariel.Atlantida.Model.Cliente;
import com.ariel.Atlantida.dto.ClienteDtoCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/clientes")
@Tag(name = "Cliente", description = "Operações relacionadas ao recurso Cliente")
public interface ClienteApi {

    @Operation(summary = "Cria um novo cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o cliente")
    })
    @PostMapping
    ResponseEntity<Cliente> criarCliente(@Valid @RequestBody ClienteDtoCreate clienteDtoCreate);

    @Operation(summary = "Busca um cliente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDtoCreate.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{idCliente}")
    ResponseEntity<ClienteDtoCreate> buscarCliente(@PathVariable int idCliente);

    @Operation(summary = "Busca um cliente pelo CPF")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDtoCreate.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/cpf/{cpf}")
    ResponseEntity<ClienteDtoCreate> buscarClientePorCpf(@PathVariable String cpf);

    @Operation(summary = "Lista todos os clientes")
    @ApiResponse(responseCode = "200", description = "Lista de clientes recuperada com sucesso",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClienteDtoCreate.class))))
    @GetMapping
    ResponseEntity<List<ClienteDtoCreate>> listarClientes();

    @Operation(summary = "Atualiza um cliente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @PutMapping("/{idCliente}")
    ResponseEntity<Cliente> atualizarCliente(@PathVariable int idCliente,
                                             @Valid @RequestBody ClienteDtoCreate clienteDtoCreate);
}
