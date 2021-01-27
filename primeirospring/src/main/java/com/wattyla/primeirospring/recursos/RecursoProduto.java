package com.wattyla.primeirospring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wattyla.primeirospring.entidades.Produto;
import com.wattyla.primeirospring.servicos.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	
	@Autowired
	private ServicoProduto servicoProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		List<Produto> listaProduto = servicoProduto.buscarTodos();
		return ResponseEntity.ok().body(listaProduto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){
		Produto produto = servicoProduto.buscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}
}
