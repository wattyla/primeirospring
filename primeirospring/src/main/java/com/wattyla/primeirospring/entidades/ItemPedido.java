package com.wattyla.primeirospring.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wattyla.primeirospring.entidades.pk.PKItemPedido;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	@EqualsAndHashCode.Include
	@EmbeddedId
	private PKItemPedido id = new PKItemPedido();

	private Integer quantidade;
	private Double preco;

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public double getSubTotal() {
		return quantidade * preco;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

}
