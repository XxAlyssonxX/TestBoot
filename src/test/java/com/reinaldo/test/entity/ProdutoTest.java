package com.reinaldo.test.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.reinaldo.entities.Produto;

class ProdutoTest {

	private Produto produto;
	
	@BeforeEach
	void setUp () {
		//Arrange
		produto = new Produto(1L,"Everton", "evertonGames@gmail.com", 1.0);
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		produto.setId(2L);
		//Assert
		assertEquals(2L, produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		produto.setNome("Maria");
		//Assert
		assertEquals("Maria", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
		//Act
		produto.setDescricao("maria@gmail.com");
		//Assert
		assertEquals("maria@gmail.com",produto.getDescricao());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		//Act
		produto.setPreco(1.0);
		//Assert
		assertEquals(1.0, produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Produto novoProduto = new Produto(3L, "Olivia", "olivia@gmail.com", 1.0);
		//Assertion
		assertAll("novoProduto",
				()-> assertEquals (3L, novoProduto.getId()),
				()-> assertEquals ("Olivia", novoProduto.getNome()),
				()-> assertEquals ("olivia@gmail.com", novoProduto.getDescricao()),
				()-> assertEquals (1.0, novoProduto.getPreco()));
	}

}

