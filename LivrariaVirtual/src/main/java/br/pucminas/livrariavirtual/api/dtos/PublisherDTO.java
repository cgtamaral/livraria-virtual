package br.pucminas.livrariavirtual.api.dtos;

import java.util.List;

public class PublisherDTO {
	
	private Integer id;
	private String name;
	private List<AuthorDTO> authors; 
	private String about;
	private List<BookDTO> books;
	
	public PublisherDTO(Integer id, String name, List<AuthorDTO> authors, String about, List<BookDTO> books) {
		super();
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.about = about;
		this.books = books;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AuthorDTO> getAuthors() {
		return authors;
	}
	public void setAuthors(List<AuthorDTO> authors) {
		this.authors = authors;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
}
