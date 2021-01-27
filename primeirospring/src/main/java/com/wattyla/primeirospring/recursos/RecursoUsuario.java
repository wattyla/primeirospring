package com.wattyla.primeirospring.recursos;

import java.net.URI;
import java.util.List;

import javax.servlet.ServletSecurityElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wattyla.primeirospring.entidades.Usuario;
import com.wattyla.primeirospring.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

	@Autowired
	private ServicoUsuario servicosUsuario;

	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> listaUsuario = servicosUsuario.buscarTodos();
		return ResponseEntity.ok().body(listaUsuario);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorI(@PathVariable Integer id) {
		Usuario usuario = servicosUsuario.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		usuario = servicosUsuario.salvar(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
}
