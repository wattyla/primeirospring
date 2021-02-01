package com.wattyla.primeirospring.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wattyla.primeirospring.entidades.Pedido;
import com.wattyla.primeirospring.servicos.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {
	
	@Autowired
	private ServicoPedido servicoPedido;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos(){
		List<Pedido> listaPedido = servicoPedido.buscarTodos();
		return ResponseEntity.ok().body(listaPedido);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
		Pedido pedido = servicoPedido.buscarPorId(id);
		return ResponseEntity.ok().body(pedido);
	}
}
