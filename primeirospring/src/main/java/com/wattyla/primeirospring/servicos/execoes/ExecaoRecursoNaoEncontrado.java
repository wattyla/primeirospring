package com.wattyla.primeirospring.servicos.execoes;

public class ExecaoRecursoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExecaoRecursoNaoEncontrado(Object id) {
		super("Recurso não encontrado. Id " + id);
	}
}
