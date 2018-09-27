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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "publishers", description = "Recurso para gerenciamento de editoras", tags={ "publishers"})
public class PublisherController {
	
	private static final Logger log = LoggerFactory.getLogger(PublisherController.class);
	
	@ApiOperation(value = "Recupera todas as editoras existentes", nickname = "findAllPublishers", notes = "", tags={ "publishers"})
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
	
	@ApiOperation(value = "Recupera as informações de uma editora especifica", nickname = "findPublisherById", notes = "", tags={ "publishers"})
	@GetMapping(value ="/publishers/{publisherId}")
	public ResponseEntity<Response<PublisherDTO>> findPublisherById(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando editora: {}" + publisherId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera todos os livros publicados por uma editora especifica", nickname = "findAllBooksForPublisher", notes = "", tags={ "publishers"})
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
	
	@ApiOperation(value = "Recupera todos os autores com livros publicados por uma editora especifica", nickname = "findAllAuthorsForPublisher", notes = "", tags={ "publishers"})
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
	
	@ApiOperation(value = "Insere uma nova editora", nickname = "insertPublisher", notes = "", tags={ "publishers"})
	@PostMapping(value ="/publishers")
	public ResponseEntity<Response<PublisherDTO>> insertPublisher()
	{
		log.info("Inserindo nova editora editora: {}");
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de uma editora", nickname = "updatePublisher", notes = "", tags={ "publishers"})
	@PutMapping(value ="/publishers/{publisherId}")
	public ResponseEntity<Response<PublisherDTO>> updatePublisher(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Editando a editora: {}" + publisherId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove uma editora especifica", nickname = "deletePublisher", notes = "", tags={ "publishers"})
	@DeleteMapping(value ="/publishers/{publisherId}")
	public ResponseEntity<Response<String>> deletePublisher(@PathVariable("publisherId") Long publisherId)
	{
		log.info("Removendo a editora: {}" + publisherId);
		Response<String> response = new Response<String>();
		
		
		return ResponseEntity.ok().body(response);
	}

}
