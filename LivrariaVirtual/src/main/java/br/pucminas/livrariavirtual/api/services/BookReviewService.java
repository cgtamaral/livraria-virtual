package br.pucminas.livrariavirtual.api.services;

import br.pucminas.livrariavirtual.api.entities.BookReview;

public interface BookReviewService {

	/**
	 * Insere na base de dados um comentário para um livro.
	 * 
	 * @param bookReview
	 * @return BookReview
	 */
	BookReview insert(BookReview bookReview);
}
