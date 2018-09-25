package br.pucminas.livrariavirtual.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.livrariavirtual.api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
