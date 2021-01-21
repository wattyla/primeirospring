package com.wattyla.primeirospring.configuracoes;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wattyla.primeirospring.entidades.Pedido;
import com.wattyla.primeirospring.entidades.Usuario;
import com.wattyla.primeirospring.repositorios.RepositorioPedido;
import com.wattyla.primeirospring.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfiguracaoTeste implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), usuario1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), usuario2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), usuario1);
		
		repositorioUsuario.saveAll(Arrays.asList(usuario1, usuario2));
		repositorioPedido.saveAll(Arrays.asList(p1,p2,p3));
	}
	
}
