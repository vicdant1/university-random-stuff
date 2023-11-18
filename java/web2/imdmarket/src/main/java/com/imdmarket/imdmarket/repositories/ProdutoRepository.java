package com.imdmarket.imdmarket.repositories;

import com.imdmarket.imdmarket.models.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutosEntity, Integer> {
    ProdutosEntity findById(int id);
}
