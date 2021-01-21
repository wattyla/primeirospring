package com.wattyla.primeirospring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wattyla.primeirospring.entidades.Usuario;
import com.wattyla.primeirospring.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicosUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos(){
		List<Usuario> listaUsuario = servicosUsuario.buscarTodos();
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){
		Usuario usuario = servicosUsuario.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}
}
