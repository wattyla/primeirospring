package com.wattyla.primeirospring.entidades.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wattyla.primeirospring.entidades.Pedido;
import com.wattyla.primeirospring.entidades.Produto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable //Incorporável
public class PKItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
}
