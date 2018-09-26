package br.pucminas.livrariavirtual.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.livrariavirtual.api.entities.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

}
