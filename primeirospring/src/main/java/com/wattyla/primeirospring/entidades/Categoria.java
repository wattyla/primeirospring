package com.wattyla.primeirospring.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Integer id;
	@Setter
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categorias")
	private Set<Produto> produtos = new HashSet<>();

	public Categoria(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
