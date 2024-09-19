package com.example.projetoexemploreactivespring.repository;

import com.example.projetoexemploreactivespring.model.Produto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends R2dbcRepository<Produto, Long> {
}
