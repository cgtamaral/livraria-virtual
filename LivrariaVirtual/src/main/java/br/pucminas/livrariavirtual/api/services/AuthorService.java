package br.pucminas.livrariavirtual.api.services;

import java.util.List;

import br.pucminas.livrariavirtual.api.entities.Author;

public interface AuthorService {

	/**
	 * Retorna uma listagem de todos os autores existentes na base de dados.
	 * 
	 * @return List<Author>
	 */
	List<Author> findAll();

}
