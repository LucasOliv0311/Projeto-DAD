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
@Tag(name = "Cliente", description = "Endpoints para gerenciar clientes")
public interface ClienteApi {

    @Operation(summary = "Cria um novo Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao criar o Cliente")
    })
    @PostMapping
    ResponseEntity<Cliente> criarCliente(@Valid @RequestBody ClienteDtoCreate clienteDtoCreate);

    @Operation(summary = "Busca um Cliente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{idCliente}")
    ResponseEntity<ClienteDtoCreate> buscarCliente(@PathVariable int idCliente);

    @Operation(summary = "Busca um Cliente pelo CPF")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/cpf/{cpf}")
    ResponseEntity<ClienteDtoCreate> buscarClientePorCpf(@PathVariable String cpf);

    @Operation(summary = "Lista todos os Clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Clientes recuperada com sucesso",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Cliente.class))))
    })
    @GetMapping
    ResponseEntity<List<ClienteDtoCreate>> listarClientes();

    @Operation(summary = "Atualiza um Cliente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @PutMapping("/{idCliente}")
    ResponseEntity<Cliente> atualizarCliente(@PathVariable int idCliente,
                                             @Valid @RequestBody ClienteDtoCreate clienteDtoCreate);

    @Operation(summary = "Deleta um Cliente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/{idCliente}")
    ResponseEntity<Void> deletarCliente(@PathVariable int idCliente);
}
