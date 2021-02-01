package com.wattyla.primeirospring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wattyla.primeirospring.entidades.Categoria;
import com.wattyla.primeirospring.servicos.ServicoCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria {
	
	@Autowired
	private ServicoCategoria servicoCategoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos(){
		List<Categoria> listaCategoria = servicoCategoria.buscarTodos();
		return ResponseEntity.ok().body(listaCategoria);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id){
		Categoria categoria = servicoCategoria.buscarPorId(id);
		return ResponseEntity.ok().body(categoria);
	}
}
