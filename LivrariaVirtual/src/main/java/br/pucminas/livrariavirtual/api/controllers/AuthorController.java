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
import br.pucminas.livrariavirtual.api.dtos.AuthorDTO;
import br.pucminas.livrariavirtual.api.entities.Author;
import br.pucminas.livrariavirtual.api.services.AuthorService;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
public class AuthorController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping(value ="/autores")
	public ResponseEntity<Response<List<AuthorDTO>>> findAll()
	{
		log.info("Buscando todos os autores da base! {}");
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

}
