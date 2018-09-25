package br.pucminas.livrariavirtual.api.dtos;

import java.util.List;

public class AuthorDTO {
	
	private Integer id;
	private String name;
	private String biography;
	private List<BookDTO> books;
	private List<PublisherDTO> publishers;
	
	public AuthorDTO() {}
	
		
	public AuthorDTO(Integer id, String name, String biography, List<BookDTO> books, List<PublisherDTO> publishers) {
		this.id = id;
		this.name = name;
		this.biography = biography;
		this.books = books;
		this.publishers = publishers;
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
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public List<BookDTO> getBooks() {
		return books;
	}
	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	public List<PublisherDTO> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<PublisherDTO> publishers) {
		this.publishers = publishers;
	}

}
