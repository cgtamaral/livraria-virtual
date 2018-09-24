package br.pucminas.livrariavirtual.api.services;


import java.util.List;

import br.pucminas.livrariavirtual.api.entities.Book;

public interface BookService {

	/**
	 * Retorna uma listagem de todos os livros existentes na base de dados.
	 * 
	 * @return List<Livro>
	 */
	List<Book> findAll();

}
