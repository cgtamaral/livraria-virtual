package br.pucminas.livrariavirtual.api.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import br.pucminas.livrariavirtual.api.dtos.BookReviewDTO;
import br.pucminas.livrariavirtual.api.dtos.PublisherDTO;
import br.pucminas.livrariavirtual.api.entities.Author;
import br.pucminas.livrariavirtual.api.entities.Book;
import br.pucminas.livrariavirtual.api.entities.BookReview;
import br.pucminas.livrariavirtual.api.entities.Customer;
import br.pucminas.livrariavirtual.api.entities.Publisher;
import br.pucminas.livrariavirtual.api.services.BookReviewService;
import br.pucminas.livrariavirtual.api.services.BookService;
import br.pucminas.livrariavirtual.api.services.CustomerService;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "Books", description = "Recurso para gerenciamento de livros")
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;
	
	@Autowired
	BookReviewService bookReviewService;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value ="/books")
	public ResponseEntity<Response<List<BookDTO>>> findAll()
	{
		log.info("Buscando todos os livros existentes na base! {}");
		Response<List<BookDTO>> response = new Response<List<BookDTO>>();
		List<Book> livros = bookService.findAll();

		if (livros == null || livros.size() == 0) {
			log.info("Nenhum livro foi encontrado na base de dados!");
			response.getErrors().add("Nenhum livro foi encontrado na base de dados!");
			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(Book.convertToDTO(livros));
		
		return ResponseEntity.ok(response);
	}

	@GetMapping(value ="/books/{bookId}/authors")
	public ResponseEntity<Response<List<AuthorDTO>>> findAllAuthorsForBook(@PathVariable("bookId") Long bookId)
	{
		log.info("Buscando todos os autores do livro {}:" + bookId);
		Response<List<AuthorDTO>> response = new Response<List<AuthorDTO>>();
		Optional<Book> book = bookService.findById(bookId);
		
		if (!book.isPresent()) {
			log.info("Nenhum livro foi encontrado para o idLivro {}:", bookId);
			response.getErrors().add("Nenhum livro foi encontrado para o idLivro " + bookId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(Author.convertToDTO(book.get().getAuthors()));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value ="/books/{bookId}/publishers")
	public ResponseEntity<Response<PublisherDTO>> findPublisherForBook(@PathVariable("bookId") Long bookId)
	{	
		log.info("Buscando editora do livro: {}" + bookId);
		Response<PublisherDTO> response = new Response<PublisherDTO>();
		Optional<Book> book = bookService.findById(bookId);
		
		if (!book.isPresent()) {
			log.info("Nenhum livro foi encontrado para o idLivro: {}", bookId);
			response.getErrors().add("Nenhum livro foi encontrado para o idLivro " + bookId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(Publisher.convertToDTO(book.get().getPublisher()));
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value ="/books/{bookId}/bookReviews")
	public ResponseEntity<Response<List<BookReviewDTO>>> findAllBookReviewForBook(@PathVariable("bookId") Long bookId)
	{
		log.info("Buscando todos os comentários de um livro na base! {}");
		Response<List<BookReviewDTO>> response = new Response<List<BookReviewDTO>>();
		Optional<Book> book = bookService.findById(bookId);
		
		if (!book.isPresent()) {
			log.info("Nenhum livro foi encontrado para o idLivro: {}", bookId);
			response.getErrors().add("Nenhum livro foi encontrado para o idLivro " + bookId);
			return ResponseEntity.badRequest().body(response);
		}
		
		if(book.get().getBookReviews()==null || book.get().getBookReviews().size() == 0)
		{
			log.info("Nenhum comentário cadastrado até o momento para o livro com idLivro: {}", bookId);
			response.getErrors().add("Nenhum comentário cadastrado até o momento para o livro com idLivro " + bookId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(BookReview.convertToDTO(book.get().getBookReviews()));
		
		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/books/{bookId}/bookReviews")
	public ResponseEntity<Response<BookReviewDTO>> insertBookReviewForBook(@PathVariable("bookId") Long bookId, 
			@Valid @RequestBody BookReviewDTO bookReviewDTO,  BindingResult result)
	{
		log.info("Inserindo comentário para o livro: {}" + bookId);
		Response<BookReviewDTO> response = new Response<BookReviewDTO>();
		validateBookReview(bookReviewDTO,  result);
		BookReview bookReview = this.convertBookReviewDTOToEntity(bookId, bookReviewDTO, result);
		if (result.hasErrors()) 
		{
			log.error("Erro ao validar comentário: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		bookReview = bookReviewService.insert(bookReview);
		response.setData(BookReview.convertToDTO(bookReview));
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/books/{bookId}/bookReviews/{bookReviewId}")
	public ResponseEntity<Response<BookReviewDTO>> updateBookReviewForBook(@PathVariable("bookId") Long bookId, @PathVariable("bookId") Long bookReviewId,
			@Valid @RequestBody BookReviewDTO bookReviewDTO,  BindingResult result)
	{
		log.info("Atualizando comentário {} "+bookReviewId+" para o livro {}" + bookId);
		Response<BookReviewDTO> response = new Response<BookReviewDTO>();
		
		response.setData(new BookReviewDTO());
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@DeleteMapping(value = "/books/{bookId}/bookReviews/{bookReviewId}")
	public ResponseEntity<Response<String>> deleteBookReviewForBook(@PathVariable("bookId") Long bookId, @PathVariable("bookId") Long bookReviewId)
	{
		log.info("Deletetando comentário {} "+bookReviewId+" para o livro {}: " + bookId);
		Response<String> response = new Response<String>();
		
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@PostMapping(value = "/books")
	public ResponseEntity<Response<BookDTO>> insertBook(@Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Incluindo novo livro {}");
		Response<BookDTO> response = new Response<BookDTO>();
		
		response.setData(new BookDTO());
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@PutMapping(value = "/books/{bookId}")
	public ResponseEntity<Response<BookDTO>> updateBook(@PathVariable("bookId") Long bookId, @Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Atualizando o livro: {}" + bookId);
		Response<BookDTO> response = new Response<BookDTO>();
		
		response.setData(new BookDTO());
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@DeleteMapping(value = "/books/{bookId}")
	public ResponseEntity<Response<String>> deleteBook(@PathVariable("bookId") Long bookId)
	{
		log.info("Removendo o livro: {}" + bookId);
		Response<String> response = new Response<String>();
		
		response.getErrors().add("Desculpe! Método ainda não implementado!");
		
		return ResponseEntity.badRequest().body(response);
	}
	
	private BookReview convertBookReviewDTOToEntity(Long bookId, BookReviewDTO bookReviewDTO, BindingResult result)
	{
		BookReview bookReview = new BookReview();
		Optional<Book> book = bookService.findById(bookId);
		
		if (!book.isPresent()) {
			result.addError(new ObjectError("bookId", "Não foi encontrado nenhum livro para o bookId informado."));
		}
		else
		{
			bookReview.setBook(book.get());
		}
		
		if(bookReviewDTO.getCustomerId()!=null)
		{
			Optional<Customer> customer = customerService.findById(bookReviewDTO.getCustomerId());
			if (!customer.isPresent()) {
				result.addError(new ObjectError("customerId", "Não foi encontrado nenhum Cliente para o customerId informado."));
			}
			else
			{
				bookReview.setCustomer(customer.get());
			}
		}
		
		bookReview.setStars(bookReviewDTO.getStars());
		bookReview.setTitle(bookReviewDTO.getTitle());
		bookReview.setComment(bookReviewDTO.getComment());
		bookReview.setReviewDate(Calendar.getInstance());
			
		return bookReview;
	}
	


	private void validateBookReview(BookReviewDTO bookReviewDTO, BindingResult result) 
	{
		if(bookReviewDTO.getStars()==null)
		{
			result.addError(new ObjectError("stars", "O livro deve ser pontuado de 0 a 5 estrelas para o livro!"));
			return;
		}
		else if(bookReviewDTO.getStars()> 5)
		{
			result.addError(new ObjectError("stars", "A quantidade de estrelas para o livro não pode ser superior a 5!"));
			return;
		}
		if(bookReviewDTO.getCustomerId()==null)
		{
			result.addError(new ObjectError("customerId", "O identificador do cliente deve ser informado!"));
			return;
		}
	}
}
