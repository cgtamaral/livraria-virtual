package br.pucminas.livrariavirtual.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.livrariavirtual.api.Response;
import br.pucminas.livrariavirtual.api.dtos.BookDTO;
import br.pucminas.livrariavirtual.api.entities.Book;
import br.pucminas.livrariavirtual.api.services.BookService;


@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService livroService;
	
	@GetMapping(value ="/livros")
	public ResponseEntity<Response<List<BookDTO>>> findAll()
	{
		log.info("Buscando todos os livros da base! {}");
		Response<List<BookDTO>> response = new Response<List<BookDTO>>();
		List<Book> livros = livroService.findAll();

		if (livros == null || livros.size() == 0) {
			log.info("Nenhum livro foi encontrado na base de dados!");
			response.getErrors().add("Nenhum livro foi encontrado na base de dados!");
			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(Book.convertToDTO(livros));
		
		return ResponseEntity.ok(response);
	}

}
