package br.pucminas.livrariavirtual.api.services;

import java.util.List;
import java.util.Optional;

import br.pucminas.livrariavirtual.api.entities.Author;

public interface AuthorService {

	/**
	 * Retorna uma listagem de todos os autores existentes na base de dados.
	 * 
	 * @return List<Author>
	 */
	List<Author> findAll();

	/**
	 * Retorna as informações de um autor conforme identificador passado como parâmetro.
	 * 
	 * @return Optional<Author>
	 */
	Optional<Author> findById(Long authorId);

}
