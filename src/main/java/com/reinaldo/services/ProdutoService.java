package com.reinaldo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.entities.Produto;
import com.reinaldo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	@Autowired
    ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
    
    public Produto updateProduto(Produto produto) {
    	if(produtoRepository.existsById(produto.getId())) {
    		return produtoRepository.save(produto);
    	} else {
    		throw new RuntimeException("Produto não encontrado");
    	}
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}