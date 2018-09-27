package br.pucminas.livrariavirtual.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")

@Api(value = "authors", description = "Recurso para gerenciamento de autores", tags={ "authors"})
public class AuthorController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;
	
    @ApiOperation(value = "Recupera todos os autores", nickname = "findAllAuthors", notes = "", tags={ "authors"})
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Nenhum autor foi encontrado na base de dados!") })
	@GetMapping(value ="/authors")
	public ResponseEntity<Response<List<AuthorDTO>>> findAllAuthors()
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
	
    @ApiOperation(value = "Recupera uma autor especifico", nickname = "findAuthorById", notes = "", tags={ "authors"})
	@GetMapping(value ="/authors/{authorId}")
	public ResponseEntity<Response<AuthorDTO>> findAuthorById(@PathVariable("authorId") Long authorId)
	{
		log.info("Buscando autor: {}" + authorId);
		Response<AuthorDTO> response = new Response<AuthorDTO>();
		Optional<Author> autor = authorService.findById(authorId);

		if (!autor.isPresent()) {
			log.info("Nenhum autor foi encontrado para authorId: {}" + authorId);
			response.getErrors().add("Nenhum autor foi encontrado para authorId" + authorId);
			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(Author.convertToDTO(autor.get()));
		
		return ResponseEntity.ok(response);
	}
    
    @ApiOperation(value = "Recupera todos os livros de um autor especifico", nickname = "findAllBooksForAuthor", notes = "", tags={ "authors"})
	@GetMapping(value ="/authors/{authorId}/books")
	public ResponseEntity<Response<List<BookDTO>>> findAllBooksForAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Buscando livros para o author: {}" + authorId);
		Response<List<BookDTO>> response = new Response<List<BookDTO>>();
		
		List<BookDTO> retornoFakeNull = new ArrayList<BookDTO>();
		retornoFakeNull.add(new BookDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
    @ApiOperation(value = "Recupera todas as editoras que publicaram livros de um autor especifico", nickname = "findAllPublishersForAuthor", notes = "", tags={ "authors"})
	@GetMapping(value ="/authors/{authorId}/publishers")
	public ResponseEntity<Response<List<PublisherDTO>>> findAllPublishersForAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Buscando Editoras para o author: {}" + authorId);
		Response<List<PublisherDTO>> response = new Response<List<PublisherDTO>>();
		
		List<PublisherDTO> retornoFakeNull = new ArrayList<PublisherDTO>();
		retornoFakeNull.add(new PublisherDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
    @ApiOperation(value = "Insere um novo autor", nickname = "insertAuthor", notes = "", tags={ "authors"})
	@PostMapping(value = "/authors")
	public ResponseEntity<Response<AuthorDTO>> insertAuthor(@Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Incluindo novo autor!");
		Response<AuthorDTO> response = new Response<AuthorDTO>();

		response.setData(new AuthorDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
    @ApiOperation(value = "Atualiza os dados de um autor especifico", nickname = "updateAuthor", notes = "", tags={ "authors"})
	@PutMapping(value = "/authors/{authorId}")
	public ResponseEntity<Response<AuthorDTO>> updateAuthor(@PathVariable("authorId") Long authorId, @Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Atualizando o author: {}" + authorId);
		Response<AuthorDTO> response = new Response<AuthorDTO>();

		response.setData(new AuthorDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
    @ApiOperation(value = "Remove um autor especifico", nickname = "deleteAuthor", notes = "", tags={ "authors"})
	@DeleteMapping(value = "/authors/{authorId}")
	public ResponseEntity<Response<String>> deleteAuthor(@PathVariable("authorId") Long authorId)
	{
		log.info("Removendo o autor: {}" + authorId);
		Response<String> response = new Response<String>();
				
		return ResponseEntity.ok().body(response);
	}

}
