package com.example.projetoexemploreactivespring.services;

import com.example.projetoexemploreactivespring.model.Produto;
import com.example.projetoexemploreactivespring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;


    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
/*
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }
    public Mono<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }
    public Mono<Produto> save(Produto produto) {
        return produtoRepository.save(produto);
    }
    public Mono<Void> deleteyId(Long id){
        return produtoRepository.deleteById(id);
    }
}*/
