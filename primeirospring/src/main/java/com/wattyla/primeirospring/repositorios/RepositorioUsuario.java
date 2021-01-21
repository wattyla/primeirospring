package com.wattyla.primeirospring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wattyla.primeirospring.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{

}
