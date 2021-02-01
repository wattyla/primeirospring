package com.wattyla.primeirospring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wattyla.primeirospring.entidades.ItemPedido;
import com.wattyla.primeirospring.entidades.pk.PKItemPedido;

public interface RepositorioItemPedido extends JpaRepository<ItemPedido, PKItemPedido>{

}
