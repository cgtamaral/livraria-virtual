package br.pucminas.livrariavirtual.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.livrariavirtual.api.Response;
import br.pucminas.livrariavirtual.api.dtos.AuthorDTO;
import br.pucminas.livrariavirtual.api.dtos.BookDTO;
import br.pucminas.livrariavirtual.api.dtos.PublisherDTO;
import br.pucminas.livrariavirtual.api.entities.Author;
import br.pucminas.livrariavirtual.api.services.AuthorService;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
public class AuthorController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping(value ="/authors")
	public ResponseEntity<Response<List<AuthorDTO>>> findAll()
	{
		log.info("Buscando todos os autores da base!");
		Response<List<AuthorDTO>> response = new Response<List<AuthorDTO>>();
		List<Author> autores = authorService.findAll();

		if (autores == null || autores.size() == 0) {
			log.info("Nenhum autor foi encontrado na base de dados!");
			response.getErrors().add("Nenhum autor foi encontrado na base de dados!");
			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(Author.convertToDTO(autores));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value ="/authors/{authorId}/books")
	public ResponseEntity<Response<List<BookDTO>>> findAllBooksForAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Buscando livros para o author: {}" + authorId);
		Response<List<BookDTO>> response = new Response<List<BookDTO>>();
		
		List<BookDTO> retornoFakeNull = new ArrayList<BookDTO>();
		retornoFakeNull.add(new BookDTO());
		response.setData(retornoFakeNull);
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@GetMapping(value ="/authors/{authorId}/publishers")
	public ResponseEntity<Response<List<PublisherDTO>>> findAllPublishersForAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Buscando Editoras para o author: {}" + authorId);
		Response<List<PublisherDTO>> response = new Response<List<PublisherDTO>>();
		
		List<PublisherDTO> retornoFakeNull = new ArrayList<PublisherDTO>();
		retornoFakeNull.add(new PublisherDTO());
		response.setData(retornoFakeNull);
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@PostMapping(value = "/authors")
	public ResponseEntity<Response<AuthorDTO>> insertAuthor(@Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Incluindo novo autor!");
		Response<AuthorDTO> response = new Response<AuthorDTO>();

		response.setData(new AuthorDTO());
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@PutMapping(value = "/authors/{authorId}")
	public ResponseEntity<Response<AuthorDTO>> updateAuthor(@PathVariable("authorId") Long authorId, @Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Atualizando o author: {}" + authorId);
		Response<AuthorDTO> response = new Response<AuthorDTO>();

		response.setData(new AuthorDTO());
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@DeleteMapping(value = "/authors/{authorId}")
	public ResponseEntity<Response<String>> deleteAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Removendo o autor: {}" + authorId);
		Response<String> response = new Response<String>();
		
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}

}
