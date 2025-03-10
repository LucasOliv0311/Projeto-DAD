package Service;

import Model.Cartao;
import Model.Cliente;
import dto.CartaoDtoCreate;
import Repository.CartaoRepository;
import Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Cartao criarCartao(CartaoDtoCreate cartaoDTO) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(cartaoDTO.getIdCliente()))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setTipo(cartaoDTO.getTipo());
        cartao.setIdCliente(cliente); // Alterado de 'setCliente' para 'setIdCliente'

        return cartaoRepository.save(cartao);
    }

    public Cartao buscarCartao(Long id) {
        return cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
    }

    public List<Cartao> buscarCartoesPorCliente(int idCliente) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(idCliente))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return cartaoRepository.findByClienteId(Long.valueOf(cliente.getIdCliente())); // Método de repositório ajustado
    }

    public List<Cartao> listarCartoes() {
        return cartaoRepository.findAll();
    }

    public Cartao atualizarCartao(Long id, CartaoDtoCreate cartaoDTO) {
        Cartao cartao = buscarCartao(id);

        Cliente cliente = clienteRepository.findById(Math.toIntExact(cartaoDTO.getIdCliente()))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setTipo(cartaoDTO.getTipo());
        cartao.setIdCliente(cliente); // Alterado de 'setCliente' para 'setIdCliente'

        return cartaoRepository.save(cartao);
    }

    public void deletarCartao(Long id) {
        Cartao cartao = buscarCartao(id);
        cartaoRepository.delete(cartao);
    }
}
