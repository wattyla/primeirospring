package com.wattyla.primeirospring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wattyla.primeirospring.entidades.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Integer>{

}
