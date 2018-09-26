package br.pucminas.livrariavirtual.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.livrariavirtual.api.entities.Customer;
import br.pucminas.livrariavirtual.api.repositories.CustomerRepository;
import br.pucminas.livrariavirtual.api.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Optional<Customer> findById(Long customerId) {
		
		log.info("Buscando o Cliente na base: {}" + customerId);
		return customerRepository.findById(customerId);
	}

}
