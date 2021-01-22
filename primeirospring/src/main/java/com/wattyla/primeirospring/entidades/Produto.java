package com.wattyla.primeirospring.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Integer id;
	@Setter
	private String name;
	@Setter
	private String descricao;
	@Setter
	private Double preco;
	@Setter
	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "id_produto"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	private Set<Categoria> categorias = new HashSet<>();

	public Produto(Integer id, String name, String descricao, Double preco, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

}
