package br.pucminas.livrariavirtual.api.services;

import java.util.Optional;

import br.pucminas.livrariavirtual.api.entities.Customer;

public interface CustomerService {
	
	/**
	 * Retorna um Cliente existente na base de dados conforme identificador informado via parâmetro.
	 * 
	 * @return Optional<Customer>
	 */
	Optional<Customer> findById(Long customerId);

}
