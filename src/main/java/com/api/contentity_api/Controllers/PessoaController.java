package com.api.contentity_api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.contentity_api.Domains.Pessoa;
import com.api.contentity_api.Services.PessoaService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path ="/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping(path = "/{id}")
	public Pessoa buscarId(@PathVariable Long id) {
		return service.buscarPessoa(id);
	}
	
	@GetMapping()
	public List<Pessoa> buscar() {
		return service.buscarPessoas();
	}
	
	@PostMapping()
	public Pessoa create(@RequestBody Pessoa entity) {
		return service.createPessoa(entity);
	}
	
	@PutMapping()
	public Pessoa update(@RequestBody Pessoa entity) {
	
		service.atualizarPessoa(entity);
		
		return entity;
	}
}
