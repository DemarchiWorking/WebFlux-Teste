package com.example.projetoexemploreactivespring.controller;

import com.example.projetoexemploreactivespring.model.Produto;
import com.example.projetoexemploreactivespring.repository.ProdutoRepository;
import com.example.projetoexemploreactivespring.services.ProdutoService;
import com.example.projetoexemploreactivespring.services.ProdutoWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    private ProdutoWebClient produtoWebClient;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    @GetMapping
    public Flux<Produto> findAll(){
        return produtoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Produto> findById(@PathVariable Long id){
        return produtoRepository.findById(id);
    }
    @RequestMapping(value = "/", method = {RequestMethod.POST})
    public Mono<Produto> create(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Mono<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoRepository.findById(id)
                .flatMap(existingProduto -> {
                    existingProduto.setNome(produto.getNome());
                    existingProduto.setPreco(produto.getPreco());
                    return produtoRepository.save(existingProduto);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return produtoRepository.deleteById(id);
    }
}
