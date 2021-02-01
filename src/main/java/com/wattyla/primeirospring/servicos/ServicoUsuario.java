package com.wattyla.primeirospring.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wattyla.primeirospring.entidades.Usuario;
import com.wattyla.primeirospring.repositorios.RepositorioUsuario;
import com.wattyla.primeirospring.servicos.execoes.ExecaoBancoDados;
import com.wattyla.primeirospring.servicos.execoes.ExecaoRecursoNaoEncontrado;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<Usuario> buscarTodos(){
		return repositorioUsuario.findAll();
	}
	
	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> obj = repositorioUsuario.findById(id);
		return obj.orElseThrow(() -> new ExecaoRecursoNaoEncontrado(id));
	}
	
	public Usuario salvar(Usuario usuario) {
		return repositorioUsuario.save(usuario);	
	}
	
	public void deletar(Integer id) {
		try {
			repositorioUsuario.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ExecaoRecursoNaoEncontrado(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExecaoBancoDados(e.getMessage());
		}
	}
	
	public Usuario atualiza(Integer id, Usuario obj) {
		try{
			Usuario entidade = repositorioUsuario.getOne(id);
			atualizaDados(entidade, obj);
			return repositorioUsuario.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ExecaoRecursoNaoEncontrado(id);
		}
	}

	private void atualizaDados(Usuario entidade, Usuario obj) {
		entidade.setName(obj.getName());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
