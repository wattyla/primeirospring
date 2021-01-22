package com.wattyla.primeirospring.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.wattyla.primeirospring.entidades.enums.StatusPedido;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private Instant momento;
	private Integer statusPedido;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();

	public Pedido(Integer id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatusOrdem(statusPedido);
		this.cliente = cliente;
	}

	public StatusPedido getStatusOrdem() {
		return StatusPedido.valorDe(statusPedido);
	}

	public void setStatusOrdem(StatusPedido statusPedido) {
		if (statusPedido != null)
			this.statusPedido = statusPedido.getCodigo();
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}
	
}
