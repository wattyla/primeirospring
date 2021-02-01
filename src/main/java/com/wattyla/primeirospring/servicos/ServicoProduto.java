package com.wattyla.primeirospring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wattyla.primeirospring.entidades.Produto;
import com.wattyla.primeirospring.repositorios.RepositorioProduto;

@Service
public class ServicoProduto {
	
	@Autowired
	private RepositorioProduto repositorioProduto;
	
	public List<Produto> buscarTodos(){
		return repositorioProduto.findAll();
	}
	
	public Produto buscarPorId(Integer id) {
		Optional<Produto> obj = repositorioProduto.findById(id);
		return obj.get();
	}
}
