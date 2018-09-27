package br.pucminas.livrariavirtual.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "publishers", description = "Recurso para gerenciamento de editoras", tags={ "publishers"})
public class PublisherController {
	
	private static final Logger log = LoggerFactory.getLogger(PublisherController.class);
	
	@ApiOperation(value = "Recupera todas as editoras existentes", nickname = "findAllPublishers", notes = "", tags={ "publishers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   				   @ApiResponse(code = 404, message = "Nenhuma editora foi encontrada na base de dados!") })
	@GetMapping(value ="/publishers", produces = "application/json")
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
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenuma editora foi encontrada para o id informado!")})
	@GetMapping(value ="/publishers/{publisherId}", produces = "application/json")
	public ResponseEntity<Response<PublisherDTO>> findPublisherById(@ApiParam(value = "Identificador da editora a ser consultada", required = true) @PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando editora: {}" + publisherId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera todos os livros publicados por uma editora especifica", nickname = "findAllBooksForPublisher", notes = "", tags={ "publishers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum livro foi encontrado para a editora informada!")})
	@GetMapping(value ="/publishers/{publisherId}/books", produces = "application/json")
	public ResponseEntity<Response<List<BookDTO>>> findAllBooksForPublisher(@ApiParam(value = "Identificador da editora a ter as informações de livros consultada", required = true) @PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando livros publicados pela editora: {}" + publisherId);
		Response<List<BookDTO>> response = new Response<List<BookDTO>>();
		
		List<BookDTO> retornoFakeNull = new ArrayList<BookDTO>();
		retornoFakeNull.add(new BookDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Recupera todos os autores com livros publicados por uma editora especifica", nickname = "findAllAuthorsForPublisher", notes = "", tags={ "publishers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum autor foi encontrado para a editora informada!")})
	@GetMapping(value ="/publishers/{publisherId}/authors", produces = "application/json")
	public ResponseEntity<Response<List<AuthorDTO>>> findAllAuthorsForPublisher(@ApiParam(value = "Identificador da editora a ter as informações de autores consultada", required = true) @PathVariable("publisherId") Long publisherId)
	{
		log.info("Buscando todos os autores que possuem obras pela editora: {}" + publisherId);
		Response<List<AuthorDTO>> response = new Response<List<AuthorDTO>>();
		
		List<AuthorDTO> retornoFakeNull = new ArrayList<AuthorDTO>();
		retornoFakeNull.add(new AuthorDTO());
		response.setData(retornoFakeNull);
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere uma nova editora", nickname = "insertPublisher", notes = "", tags={ "publishers"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e uma nova editora foi incluida na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão da editora!")})
	@PostMapping(value ="/publishers", produces = "application/json")
	public ResponseEntity<Response<PublisherDTO>> insertPublisher(@ApiParam(value = "Objeto de editora que precisa ser incluida na base de dados", required = true) @Valid @RequestBody PublisherDTO publisherDTO,  
			BindingResult result)
	{
		log.info("Inserindo nova editora editora: {}");
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de uma editora", nickname = "updatePublisher", notes = "", tags={ "publishers"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a editora foi atualizada na base de dados!"),
		    @ApiResponse(code = 400, message = "O request possui informações inválidas para a atualização da editora!")})
	@PutMapping(value ="/publishers/{publisherId}", produces = "application/json")
	public ResponseEntity<Response<PublisherDTO>> updatePublisher(@ApiParam(value = "Identificador da editora a ter as informações atualizadas na base de dados", required = true) @PathVariable("publisherId") Long publisherId, 
			@ApiParam(value = "Objeto de editora que precisa ser atualizada na base de dados", required = true) @Valid @RequestBody PublisherDTO publisherDTO,  
			BindingResult result)
	{
		log.info("Editando a editora: {}" + publisherId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		
		response.setData(new PublisherDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove uma editora especifica", nickname = "deletePublisher", notes = "", tags={ "publishers"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a editora foi removida na base de dados!"),
   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value ="/publishers/{publisherId}", produces = "application/json")
	public ResponseEntity<Response<String>> deletePublisher(@ApiParam(value = "Identificador da editora a ser removida na base de dados", required = true) @PathVariable("publisherId") Long publisherId)
	{
		log.info("Removendo a editora: {}" + publisherId);
		Response<String> response = new Response<String>();
		
		
		return ResponseEntity.ok().body(response);
	}

}
