package br.pucminas.livrariavirtual.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.livrariavirtual.api.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> 
{
	
}
