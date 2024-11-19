package com.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reinaldo.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto,Long> {

}
