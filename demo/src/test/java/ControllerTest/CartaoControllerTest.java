package ControllerTest;

import Controller.CartaoController;
import Model.Cartao;
import Model.Cliente;
import Service.CartaoService;
import dto.CartaoDtoCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartaoControllerTest {

    @Mock
    private CartaoService cartaoService;

    @InjectMocks
    private CartaoController cartaoController;

    private CartaoDtoCreate cartaoDtoCreate;
    private Cartao cartao;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Inicializar dados de teste
        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNome("Cliente Teste");

        cartaoDtoCreate = new CartaoDtoCreate();
        cartaoDtoCreate.setNumeroCartao("1234567812345678");
        cartaoDtoCreate.setValidade(LocalDate.of(2025, 12, 31));
        cartaoDtoCreate.setCvv("123");
        cartaoDtoCreate.setBandeira("Visa");
        cartaoDtoCreate.setTipo("Crédito");
        cartaoDtoCreate.setIdCliente(1);

        cartao = new Cartao();
        cartao.setId(1L);
        cartao.setNumeroCartao("1234567812345678");
        cartao.setValidade(LocalDate.of(2025, 12, 31));
        cartao.setCvv("123");
        cartao.setBandeira("Visa");
        cartao.setTipo("Crédito");
        cartao.setIdCliente(cliente);
    }

    @Test
    void criarCartao() {
        when(cartaoService.criarCartao(any(CartaoDtoCreate.class))).thenReturn(cartao);

        ResponseEntity<Cartao> response = cartaoController.criarCartao(cartaoDtoCreate);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("1234567812345678", response.getBody().getNumeroCartao());
    }

    @Test
    void buscarCartao() {
        when(cartaoService.buscarCartao(1L)).thenReturn(cartao);

        ResponseEntity<Cartao> response = cartaoController.buscarCartao(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void buscarCartaoNaoEncontrado() {
        when(cartaoService.buscarCartao(1L)).thenThrow(new RuntimeException("Cartão não encontrado"));

        ResponseEntity<Cartao> response = cartaoController.buscarCartao(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void listarCartoes() {
        when(cartaoService.listarCartoes()).thenReturn(Arrays.asList(cartao));

        ResponseEntity<List<Cartao>> response = cartaoController.listarCartoes();

        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody().isEmpty());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void atualizarCartao() {
        when(cartaoService.atualizarCartao(eq(1L), any(CartaoDtoCreate.class))).thenReturn(cartao);

        ResponseEntity<Cartao> response = cartaoController.atualizarCartao(1L, cartaoDtoCreate);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("1234567812345678", response.getBody().getNumeroCartao());
    }

    @Test
    void atualizarCartaoNaoEncontrado() {
        when(cartaoService.atualizarCartao(eq(1L), any(CartaoDtoCreate.class))).thenThrow(new RuntimeException("Cartão não encontrado"));

        ResponseEntity<Cartao> response = cartaoController.atualizarCartao(1L, cartaoDtoCreate);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void deletarCartao() {
        doNothing().when(cartaoService).deletarCartao(1L);

        ResponseEntity<Void> response = cartaoController.deletarCartao(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void deletarCartaoNaoEncontrado() {
        doThrow(new RuntimeException("Cartão não encontrado")).when(cartaoService).deletarCartao(1L);

        ResponseEntity<Void> response = cartaoController.deletarCartao(1L);

        assertEquals(404, response.getStatusCodeValue());
    }
}
