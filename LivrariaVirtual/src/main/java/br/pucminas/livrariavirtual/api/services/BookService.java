package br.pucminas.livrariavirtual.api.services;


import java.util.List;
import java.util.Optional;

import br.pucminas.livrariavirtual.api.entities.Book;

public interface BookService {

	/**
	 * Retorna uma listagem de todos os livros existentes na base de dados.
	 * 
	 * @return List<Book>
	 */
	List<Book> findAll();

	/**
	 * Retorna um livro existente na base de dados conforme identificador informado via parâmetro.
	 * 
	 * @return Optional<Book>
	 */
	Optional<Book> findById(Long bookId);

}
