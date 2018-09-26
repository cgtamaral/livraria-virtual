package br.pucminas.livrariavirtual.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.livrariavirtual.api.entities.BookReview;
import br.pucminas.livrariavirtual.api.repositories.BookReviewRepository;
import br.pucminas.livrariavirtual.api.services.BookReviewService;

@Service
public class BookReviewServiceImpl implements BookReviewService{
	
	private static final Logger log = LoggerFactory.getLogger(BookReviewServiceImpl.class);
	
	@Autowired
	BookReviewRepository bookReviewRepository;
	
	@Override
	public BookReview insert(BookReview bookReview) {
		log.info("Persistindo o comentário: {}", bookReview);
		return bookReviewRepository.save(bookReview);
	}

}
