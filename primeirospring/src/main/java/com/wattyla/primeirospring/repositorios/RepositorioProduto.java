package com.wattyla.primeirospring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wattyla.primeirospring.entidades.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Integer>{

}
