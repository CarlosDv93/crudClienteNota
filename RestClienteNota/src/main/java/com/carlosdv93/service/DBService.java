package com.carlosdv93.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.carlosdv93.RestApplication;
import com.carlosdv93.model.Cliente;
import com.carlosdv93.model.Telefone;
import com.carlosdv93.repositories.ClienteRepository;
import com.carlosdv93.repositories.TelefoneRepository;
import com.carlosdv93.utils.TipoCliente;

@Service
public class DBService {
	
private static final Logger log = LoggerFactory.getLogger(RestApplication.class);
	
	@Autowired
	private ClienteRepository pessoaRP;
	
	@Autowired
	private TelefoneRepository telefoneRP;
	
	@Bean
	public boolean instatiateDatabase() {
		
		Cliente cli1 = new Cliente("Carlos David", "221.566.666-87", TipoCliente.FISICA, 37, 32425926);
		pessoaRP.save(cli1);
		
		Cliente cli2 = new Cliente("Teste", "922.250.086-55", TipoCliente.FISICA, 37, 32425926);
		pessoaRP.save(cli2);
		
		Cliente cli3 = new Cliente("Teste123", "263.914.216-09", TipoCliente.FISICA, 37, 32425926);
		pessoaRP.save(cli3);
		
		Cliente cli4 = new Cliente("Teste456", "250.686.136-06", TipoCliente.JURIDICA, 37, 32425926);
		pessoaRP.save(cli4);
		
		log.info("Salvo");
		
		return true;
	}

}
