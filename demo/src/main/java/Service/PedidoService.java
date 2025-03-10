package Service;

import Model.Pedido;
import Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(Math.toIntExact(id));
        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setId(pedidoAtualizado.getId());
            pedido.setProduto(pedidoAtualizado.getProduto());
            pedido.setCartao(pedidoAtualizado.getCartao());
            pedido.setDataPedido(pedidoAtualizado.getDataPedido());
            pedido.setValorTotal(pedidoAtualizado.getValorTotal());
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(Math.toIntExact(id));
    }
}
