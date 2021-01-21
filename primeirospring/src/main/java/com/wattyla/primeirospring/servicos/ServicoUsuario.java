package com.wattyla.primeirospring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wattyla.primeirospring.entidades.Usuario;
import com.wattyla.primeirospring.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<Usuario> buscarTodos(){
		return repositorioUsuario.findAll();
	}
	
	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> obj = repositorioUsuario.findById(id);
		return obj.get();
	}
}
