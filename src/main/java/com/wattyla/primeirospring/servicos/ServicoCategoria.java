package com.wattyla.primeirospring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wattyla.primeirospring.entidades.Categoria;
import com.wattyla.primeirospring.repositorios.RepositorioCategoria;

@Service
public class ServicoCategoria {
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	public List<Categoria> buscarTodos(){
		return repositorioCategoria.findAll();
	}
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> obj = repositorioCategoria.findById(id);
		return obj.get();
	}
}
