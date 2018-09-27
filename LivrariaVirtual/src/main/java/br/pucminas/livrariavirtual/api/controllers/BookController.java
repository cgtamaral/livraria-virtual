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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "books", description = "Recurso para gerenciamento de livros", tags={ "books"})
public class BookController {
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;
	
	@Autowired
	BookReviewService bookReviewService;
	
	@Autowired
	CustomerService customerService;
	
	@ApiOperation(value = "Recupera todos os livros", nickname = "findAllBooks", notes = "", tags={ "books"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   	@ApiResponse(code = 404, message = "Nenhum livro foi encontrado na base de dados!") })
	@GetMapping(value ="/books", produces = "application/json")
	public ResponseEntity<Response<List<BookDTO>>> findAllBooks()
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
	
	@ApiOperation(value = "Recupera as informações dos autores de um livro especifico", nickname = "findAllAuthorsForBook", notes = "", tags={ "books"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
			@ApiResponse(code = 404, message = "Nenhum livro foi encontrado para o id informado!")})
	@GetMapping(value ="/books/{bookId}/authors", produces = "application/json")
	public ResponseEntity<Response<List<AuthorDTO>>> findAllAuthorsForBook(@ApiParam(value = "Identificador do livro a ser consultado", required = true) @PathVariable("bookId") Long bookId)
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
	
	@ApiOperation(value = "Recupera as informações da editora de um livro especifico", nickname = "findPublisherForBook", notes = "", tags={ "books"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
			    @ApiResponse(code = 400, message = "O id informado é inválido!"),
				@ApiResponse(code = 404, message = "Nenhuma editora foi encontrado para o livro informado!")})
	@GetMapping(value ="/books/{bookId}/publishers", produces = "application/json")
	public ResponseEntity<Response<PublisherDTO>> findPublisherForBook(@ApiParam(value = "Identificador do livro a ter as informações de editora consultada", required = true) @PathVariable("bookId") Long bookId)
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
	
	@ApiOperation(value = "Recupera todas as avaliações de um livro especifico", nickname = "findAllBookReviewForBook", notes = "", tags={ "books"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 400, message = "O id informado é inválido!"),
		    @ApiResponse(code = 404, message = "Nenhum registro foi encontrado na base de dados!")})
	@GetMapping(value ="/books/{bookId}/bookReviews", produces = "application/json")
	public ResponseEntity<Response<List<BookReviewDTO>>> findAllBookReviewForBook(@ApiParam(value = "Identificador do livro a ter as informações de avaliação de clientes consultadas", required = true) @PathVariable("bookId") Long bookId)
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
	
	@ApiOperation(value = "Insere uma nova avaliação para um livro especifico", nickname = "insertBookReviewForBook", notes = "", tags={ "books"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e uma nova avaliação foi incluida para o livro na base de dados"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PostMapping(value = "/books/{bookId}/bookReviews", produces = "application/json")
	public ResponseEntity<Response<BookReviewDTO>> insertBookReviewForBook(@ApiParam(value = "Identificador do livro a ter uma avaliação incluida na base de dados", required = true) @PathVariable("bookId") Long bookId, 
			@ApiParam(value = "Objeto de avaliação livro que precisa ser incluido na base de dados", required = true) @Valid @RequestBody BookReviewDTO bookReviewDTO,  BindingResult result)
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
	
	@ApiOperation(value = "Atualiza uma determinada avaliação de um livro especifico", nickname = "updateBookReviewForBook", notes = "", tags={ "books"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a avaliação livro foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O request informado é inválido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value = "/books/{bookId}/bookReviews/{bookReviewId}", produces = "application/json")
	public ResponseEntity<Response<BookReviewDTO>> updateBookReviewForBook(@ApiParam(value = "Identificador do livro a ter uma avaliação atualizada na base de dados", required = true) @PathVariable("bookId") Long bookId,
			@ApiParam(value = "Identificador do avaliação livro a ser atualizada na base de dados", required = true) @PathVariable("bookId") Long bookReviewId,
			@ApiParam(value = "Objeto da avaliação livro que precisa ser atualizado na base de dados", required = true) @Valid @RequestBody BookReviewDTO bookReviewDTO,  BindingResult result)
	{
		log.info("Atualizando comentário {} "+bookReviewId+" para o livro {}" + bookId);
		Response<BookReviewDTO> response = new Response<BookReviewDTO>();
		
		response.setData(new BookReviewDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove uma determinada avaliação de um livro especifico", nickname = "deleteBookReviewForBook", notes = "", tags={ "books"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e a avaliação livro foi removida na base de dados!"),
			   @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value = "/books/{bookId}/bookReviews/{bookReviewId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteBookReviewForBook(@ApiParam(value = "Identificador do livro a ter uma avaliação removida na base de dados", required = true) @PathVariable("bookId") Long bookId,
			@ApiParam(value = "Identificador da avaliação livro a ser removida na base de dados", required = true) @PathVariable("bookId") Long bookReviewId)
	{
		log.info("Deletetando comentário {} "+bookReviewId+" para o livro {}: " + bookId);
		Response<String> response = new Response<String>();
		
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere um novo livro", nickname = "insertBook", notes = "", tags={ "books"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e um novo livro foi incluido na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão do livro!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PostMapping(value = "/books", produces = "application/json")
	public ResponseEntity<Response<BookDTO>> insertBook(@ApiParam(value = "Objeto do livro que precisa ser incluido na base de dados", required = true)  @Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Incluindo novo livro {}");
		Response<BookDTO> response = new Response<BookDTO>();
		
		response.setData(new BookDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Atualiza as informações de um livro especifico", nickname = "updateBook", notes = "", tags={ "books"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o livro foi atualizado na base de dados"),
		    @ApiResponse(code = 400, message = "O request possui informações inválidas para a atualização do livro!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PutMapping(value = "/books/{bookId}", produces = "application/json")
	public ResponseEntity<Response<BookDTO>> updateBook(@ApiParam(value = "Identificador do livro a ser atualizado na base de dados", required = true) @PathVariable("bookId") Long bookId, 
			@ApiParam(value = "Objeto do livro que precisa ser atualizado na base de dados", required = true) @Valid @RequestBody BookDTO bookDTO,  BindingResult result)
	{
		log.info("Atualizando o livro: {}" + bookId);
		Response<BookDTO> response = new Response<BookDTO>();
		
		response.setData(new BookDTO());
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Remove um livro especifico", nickname = "deleteBook", notes = "", tags={ "books"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida e o livro foi removido na base de dados!"),
			   			@ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@DeleteMapping(value = "/books/{bookId}", produces = "application/json")
	public ResponseEntity<Response<String>> deleteBook(@ApiParam(value = "Identificador do livro a ser removido na base de dados", required = true) @PathVariable("bookId") Long bookId)
	{
		log.info("Removendo o livro: {}" + bookId);
		Response<String> response = new Response<String>();
			
		return ResponseEntity.ok().body(response);
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
