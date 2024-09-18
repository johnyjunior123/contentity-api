package com.api.contentity_api.Exceptions;

public class PessoaNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException (Long id) {
		super ("Pessoa não encontrada com ID: " + id);
	}
}
