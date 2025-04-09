package com.ariel.Atlantida.Controller;
import com.ariel.Atlantida.Model.Carrinho;
import com.ariel.Atlantida.Service.CarrinhoService;
import com.ariel.Atlantida.dto.CarrinhoDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public Carrinho adicionar(@RequestBody CarrinhoDtoCreate dto) {
        return carrinhoService.adicionarAoCarrinho(dto);
    }

    @GetMapping
    public List<Carrinho> listarTodos() {
        return carrinhoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Carrinho buscarPorId(@PathVariable Long id) {
        return carrinhoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        carrinhoService.remover(id);
    }

    @PutMapping("/{id}")
    public Carrinho atualizarQuantidade(@PathVariable Long id, @RequestBody CarrinhoDtoCreate dto) {
        return carrinhoService.atualizarQuantidade(id, dto.getQuantidade());
    }
}

