package com.example.projetoexemploreactivespring;

import com.example.projetoexemploreactivespring.controller.ProdutoController;
import com.example.projetoexemploreactivespring.model.Produto;
import com.example.projetoexemploreactivespring.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.*;

@WebFluxTest(ProdutoController.class)
public class ProdutoControllerTest {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @BeforeEach
    void setUp(){
        produto = new Produto(1L, "Coca", 5);
    }

    @Test
    public void testFindAll(){
        doReturn(Flux.just(produto)).when(produtoRepository.findAll());
        webClient.get().uri("/api/produtos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Produto.class)
                .hasSize(1)
                .contains(produto);

        verify(produtoRepository, times(1)).findAll();
    }


}
