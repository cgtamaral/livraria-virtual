package br.pucminas.livrariavirtual.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.livrariavirtual.api.entities.Author;
import br.pucminas.livrariavirtual.api.repositories.AuthorRepository;
import br.pucminas.livrariavirtual.api.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> findAll() {
		log.info("Buscando todos os autores da base! {}");
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> findById(Long authorId) {
		log.info("Buscando autor: {}" + authorId);
		return authorRepository.findById(authorId);
	}

}
