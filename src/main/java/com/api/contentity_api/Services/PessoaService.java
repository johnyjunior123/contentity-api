package com.api.contentity_api.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contentity_api.Domains.Pessoa;
import com.api.contentity_api.Exceptions.PessoaNotFoundException;
import com.api.contentity_api.Repositories.PessoaRepository;

@Service
public class PessoaService  {

	@Autowired
	private PessoaRepository repository;
	
	public Pessoa buscarPessoa(Long id) {
		return repository.findById(id).orElseThrow( () -> new PessoaNotFoundException(id));     //CRIAR EXCEPTION PERSONALIZADA CASO O ID NN SEJA ENCONTRADO!
	}

	public List<Pessoa> buscarPessoas() {
		List<Pessoa> pessoas = repository.findAll();
		return pessoas;
	}
	
	
	public Pessoa createPessoa(Pessoa entity) {
		return repository.save(entity);
		
	}

	public Pessoa atualizarPessoa(Pessoa entity) {
		Pessoa pessoa = repository.findById(entity.getId()).orElseThrow(() -> new PessoaNotFoundException(entity.getId()));

		pessoa.setCpf(entity.getCpf());
		pessoa.setDataNascimento(entity.getDataNascimento());
		pessoa.setEmail(entity.getEmail());
		pessoa.setNome(entity.getNome());
		
		pessoa.getEnderecos().clear();
		pessoa.getEnderecos().addAll(entity.getEnderecos());
		//pessoa.setEnderecos();
		
		return repository.save(pessoa);
	}


	
	
}
