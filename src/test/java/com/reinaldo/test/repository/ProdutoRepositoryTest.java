package com.reinaldo.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.reinaldo.entities.Produto;
import com.reinaldo.repository.ProdutoRepository;

@DataJpaTest
class ProdutoRepositoryTest {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void test() {
	    // Given / Arrange
	    Produto produto1 = new Produto(1L, "Caneta", "escreve letras", 2.0);
	    // When / Act
	    Produto saveProduto = produtoRepository.save(produto1);
	    //Then / Assert
	    assertNotNull(saveProduto);
	    assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos os Produtos")
	@Test
	void testGetAllRepository() {
	    //given / Arrange
	    Produto produto1 = new Produto(1L, "Caneta", "escreve letras", 2.0);
	    Produto produto2 = new Produto(2L, "Faca", "afiada", 9.0);
	    produtoRepository.save(produto1);
	    produtoRepository.save(produto2);
	    //when / Act
	    List<Produto> produtoList = produtoRepository.findAll();
	    //then / Assert
	    assertNotNull(produtoList);
	    assertEquals(2, produtoList.size());
	}

	  @DisplayName("Testando Get By ID")
	    @Test
	    void testGetById() {
	        // Given / Arrange
	        Produto produto1 = new Produto(null, "Caneta", "escreve letras", 2.0);
	        Produto savedProduto = produtoRepository.save(produto1);
	        // When / Act
	        Optional<Produto> produtoOptional = produtoRepository.findById(savedProduto.getId());
	        // Then / Assert
	        assertTrue(produtoOptional.isPresent(), "Produto deve estar presente");
	        assertEquals(savedProduto.getId(), produtoOptional.get().getId());
	    }

	 @DisplayName("Testando o Update")
	    @Test
	    void testUpdateProduto() {
	        // Given / Arrange
	        Produto produto1 = new Produto(null, "Caneta", "escreve letras", 2.0);
	        Produto savedProduto = produtoRepository.save(produto1);
	        
	        // When / Act
	        savedProduto.setNome("Mouse");
	        savedProduto.setPreco(250.0);
	        savedProduto.setDescricao("Usado para navegar");
	        Produto updatedProduto = produtoRepository.save(savedProduto); // Salva o produto atualizado
	        
	        // Then / Assert
	        assertNotNull(updatedProduto);
	        assertEquals("Mouse", updatedProduto.getNome());
	        assertEquals(250.0, updatedProduto.getPreco());
	        assertEquals("Usado para navegar", updatedProduto.getDescricao());
	    }

	@DisplayName("Testando o Delete")
	@Test
	void testDeleteProduto() {
	    //given / Arrange
	    Produto produto1 = new Produto(1L, "Caneta", "escreve letras", 2.0);
	    produtoRepository.save(produto1);
	    //when / Act
	    produtoRepository.deleteById(produto1.getId());
	    Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());
	    //then / assert
	    assertTrue(produtoOptional.isEmpty());
	}
	
	
}
