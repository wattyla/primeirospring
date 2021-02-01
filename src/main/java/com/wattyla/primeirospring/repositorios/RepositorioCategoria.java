package com.wattyla.primeirospring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wattyla.primeirospring.entidades.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Integer>{

}
