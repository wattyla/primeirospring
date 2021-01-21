package com.wattyla.primeirospring.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wattyla.primeirospring.entidades.Pedido;
import com.wattyla.primeirospring.repositorios.RepositorioPedido;

@Service
public class ServicoPedido {
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	public List<Pedido> buscarTodos(){
		return repositorioPedido.findAll();
	}
	
	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> obj = repositorioPedido.findById(id);
		return obj.get();
	}
}
