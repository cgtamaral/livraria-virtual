package br.pucminas.livrariavirtual.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.livrariavirtual.api.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
