package br.pucminas.livrariavirtual.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.livrariavirtual.api.Response;
import br.pucminas.livrariavirtual.api.dtos.AuthorDTO;
import br.pucminas.livrariavirtual.api.dtos.BookDTO;
import br.pucminas.livrariavirtual.api.dtos.PublisherDTO;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "Publishers", description = "Recurso para gerenciamento de editoras")
public class PublisherController {
	
	private static final Logger log = LoggerFactory.getLogger(PublisherController.class);
	
	@GetMapping(value ="/publishers")
	public ResponseEntity<Response<List<PublisherDTO>>> findAllPublishers()
	{
		log.info("Buscando todas as editoras existentes na base de dados!");
		Response<List<PublisherDTO>> response = new Response<List<PublisherDTO>>();
		
		List<PublisherDTO> retornoFakeNull = new ArrayList<PublisherDTO>();
		retornoFakeNull.add(new PublisherDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value ="/publishers/{publisherId}")
	public ResponseEntity<Response<PublisherDTO>> findPublisherById(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando editora: {}" + publisherId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	
	@GetMapping(value ="/publishers/{publisherId}/books")
	public ResponseEntity<Response<List<BookDTO>>> findAllBooksForPublisher(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando livros publicados pela editora: {}" + publisherId);
		Response<List<BookDTO>> response = new Response<List<BookDTO>>();
		
		List<BookDTO> retornoFakeNull = new ArrayList<BookDTO>();
		retornoFakeNull.add(new BookDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
	
	@GetMapping(value ="/publishers/{publisherId}/authors")
	public ResponseEntity<Response<List<AuthorDTO>>> findAllAuthorsForPublisher(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando todos os autores que possuem obras pela editora: {}" + publisherId);
		Response<List<AuthorDTO>> response = new Response<List<AuthorDTO>>();
		
		List<AuthorDTO> retornoFakeNull = new ArrayList<AuthorDTO>();
		retornoFakeNull.add(new AuthorDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value ="/publishers")
	public ResponseEntity<Response<PublisherDTO>> insertPublisher()
	{
		log.info("Inserindo nova editora editora: {}");
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value ="/publishers/{publisherId}")
	public ResponseEntity<Response<PublisherDTO>> updatePublisher(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Editando a editora: {}" + publisherId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value ="/publishers/{publisherId}")
	public ResponseEntity<Response<String>> deleteAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Removendo a editora: {}" + authorId);
		Response<String> response = new Response<String>();
		
		
		return ResponseEntity.ok().body(response);
	}

}
