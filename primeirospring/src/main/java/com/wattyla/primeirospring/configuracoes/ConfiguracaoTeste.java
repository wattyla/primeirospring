package com.wattyla.primeirospring.configuracoes;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wattyla.primeirospring.entidades.Categoria;
import com.wattyla.primeirospring.entidades.ItemPedido;
import com.wattyla.primeirospring.entidades.Pedido;
import com.wattyla.primeirospring.entidades.Produto;
import com.wattyla.primeirospring.entidades.Usuario;
import com.wattyla.primeirospring.entidades.enums.StatusPedido;
import com.wattyla.primeirospring.repositorios.RepositorioCategoria;
import com.wattyla.primeirospring.repositorios.RepositorioItemPedido;
import com.wattyla.primeirospring.repositorios.RepositorioPedido;
import com.wattyla.primeirospring.repositorios.RepositorioProduto;
import com.wattyla.primeirospring.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class ConfiguracaoTeste implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Autowired
	private RepositorioItemPedido repositorioItemPedido;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		repositorioProduto.saveAll(Arrays.asList(produto1,produto2,produto3,produto4,produto5));
		repositorioCategoria.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		produto1.getCategorias().add(cat2);
		produto2.getCategorias().add(cat1);
		produto2.getCategorias().add(cat3);
		produto3.getCategorias().add(cat3);
		produto4.getCategorias().add(cat3);
		produto5.getCategorias().add(cat2);
		
		repositorioProduto.saveAll(Arrays.asList(produto1,produto2,produto3,produto4,produto5));
		
		
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.ENTREGUE, usuario1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.CANCELADO, usuario1);
		
		repositorioUsuario.saveAll(Arrays.asList(usuario1, usuario2));
		repositorioPedido.saveAll(Arrays.asList(p1,p2,p3));
		
		ItemPedido oi1 = new ItemPedido(p1, produto1, 2, produto1.getPreco());
		ItemPedido oi2 = new ItemPedido(p1, produto3, 1, produto3.getPreco());
		ItemPedido oi3 = new ItemPedido(p2, produto3, 2, produto3.getPreco());
		ItemPedido oi4 = new ItemPedido(p3, produto5, 2, produto5.getPreco());
		
		repositorioItemPedido.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
	
}
