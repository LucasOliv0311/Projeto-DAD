package api;

import Model.Cliente;
import Model.Produto;
import dto.ClienteDtoCreate;
import dto.ProdutoDtoCreate;
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

@RequestMapping("/produtos")
@Tag(name = "Produto")
public interface ProdutoApi {
    @Operation(summary = "Salva um novo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto salvo com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "409", description = "Conflito ao salvar o Produto",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PostMapping
    ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDtoCreate produtoDtoCreate);

    @Operation(summary = "Busca um Produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @GetMapping("/{id}")
    ResponseEntity<Produto> buscarProduto(@PathVariable("id") Long id);

    @Operation(summary = "Lista todos os Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de Produtos recuperada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)))
    })
    @GetMapping
    ResponseEntity<List<Produto>> listarProdutos();

    @Operation(summary = "Atualiza um Produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<Produto> atualizarProduto(@PathVariable("id") Long id,
                                             @RequestBody ProdutoDtoCreate produtoDtoCreate);

    @Operation(summary = "Deleta um Produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Errors.class)))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletarProduto(@PathVariable("id") Long id);
}
