package com.carlosdv93.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlosdv93.model.Cliente;
import com.carlosdv93.model.Telefone;
import com.carlosdv93.repositories.ClienteRepository;

@RestController
@RequestMapping(value="api/customer")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@GetMapping(path="")
	public Iterable<Cliente> getAll(){
		return repository.findAll();
	}
	
	@PostMapping(path="")
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente pessoa){
		pessoa = repository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pessoa).toUri();
		return ResponseEntity.status(201).body(pessoa);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id){
		Cliente pessoa = repository.findOne(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Cliente> atualizarPessoa(@PathVariable Long id, @RequestBody Cliente pessoa){
		Cliente pessoa1 = repository.findOne(id);
		if(pessoa1 != null) {
			pessoa1.setNome(pessoa.getNome());
			pessoa1.setCgc(pessoa.getCgc());
			pessoa1.setNumeroTel(pessoa.getNumeroTel());
			pessoa1.setDdd(pessoa.getDdd());
			repository.save(pessoa1);
			return ResponseEntity.ok(pessoa1);
		} else {
			return (ResponseEntity<Cliente>) ResponseEntity.badRequest();
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/{id}", method=RequestMethod.POST)
	public ResponseEntity<Cliente> vincularTelefonePessoa(@PathVariable Long id, @RequestBody Telefone telefone){
		Cliente pessoa1 = repository.findOne(id);
		if(pessoa1 != null) {
			//pessoa1.setTelefones(Arrays.asList(telefone));
			repository.save(pessoa1);
			return ResponseEntity.ok(pessoa1);
		} else {
			return (ResponseEntity<Cliente>) ResponseEntity.badRequest();
		}
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletarPessoa(@PathVariable Long id){
		repository.delete(id);
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(path="/buscar", method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getByName(@RequestParam String nome){
		List<Cliente> pessoas = repository.findByNomeContainingIgnoreCase(nome);
		return ResponseEntity.ok(pessoas);
	}
}
