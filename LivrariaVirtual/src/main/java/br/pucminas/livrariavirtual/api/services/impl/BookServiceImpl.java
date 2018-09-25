package br.pucminas.livrariavirtual.api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.livrariavirtual.api.entities.Book;
import br.pucminas.livrariavirtual.api.repositories.BookRepository;
import br.pucminas.livrariavirtual.api.services.BookService;

@Service
public class BookServiceImpl implements BookService
{

	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> findAll()
	{	
		log.info("Buscando todos os livros da base! {}");
		return bookRepository.findAll();
	}

}
