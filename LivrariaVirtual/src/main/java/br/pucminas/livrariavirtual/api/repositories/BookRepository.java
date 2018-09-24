package br.pucminas.livrariavirtual.api.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.pucminas.livrariavirtual.api.entities.Book;

@Repository
public class BookRepository {

	private static final Logger log = LoggerFactory.getLogger(BookRepository.class);
	
	public List<Book> findAll() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
