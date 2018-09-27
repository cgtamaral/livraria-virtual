package br.pucminas.livrariavirtual.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import br.pucminas.livrariavirtual.api.dtos.AuthorDTO;

@Entity
public class Author 
{
	private Integer id;
	private String name;
	private String biography;
	private List<Book> books;
	private List<Publisher> publishers;
	
	public Author() {}
	
	public Author(Integer id, String name, String biography, List<Book> books, List<Publisher> publishers) 
	{
		this.id = id;
		this.name = name;
		this.biography = biography;
		this.books = books;
		this.publishers = publishers;
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
	
	@Column(name = "biography", length = 4000, nullable = false)
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Author_Book", joinColumns = {@JoinColumn(name = "author_id") }, inverseJoinColumns = {@JoinColumn(name = "book_id") })
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Author_Publisher", joinColumns = {@JoinColumn(name = "author_id") }, inverseJoinColumns = {@JoinColumn(name = "publisher_id") })
	public List<Publisher> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}

	@Transient
	public static List<AuthorDTO> convertToDTO(List<Author> autores) 
	{
		List<AuthorDTO> retorno = new ArrayList<AuthorDTO>();
		for (Author author : autores) {
			AuthorDTO authorDTO = convertToDTO(author);
			retorno.add(authorDTO);
		}
		return retorno;
	}

	@Transient
	public static AuthorDTO convertToDTO(Author author) {
		
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.id);
		authorDTO.setName(author.name);
		authorDTO.setBiography(author.biography);

		return authorDTO;
	}
}
