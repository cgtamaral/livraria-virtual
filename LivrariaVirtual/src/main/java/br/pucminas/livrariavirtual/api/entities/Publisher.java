package br.pucminas.livrariavirtual.api.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Publisher {

	private Integer id;
	private String name;
	private List<Author> authors; 
	private String about;
	private List<Book> books;
	
	public Publisher() {}
	
	
	public Publisher(Integer id, String name, List<Author> authors, String about, List<Book> books) {
		this.id = id;
		this.name=name;
		this.authors = authors;
		this.about = about;
		this.books = books;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy = "publishers")
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	@Column(name = "about", length=4000, nullable = false)	
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	@OneToMany
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
