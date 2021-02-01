package com.wattyla.primeirospring.servicos.execoes;

public class ExecaoBancoDados extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ExecaoBancoDados(String msg) {
		super(msg);
	}
}
