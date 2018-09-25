package br.pucminas.livrariavirtual.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import br.pucminas.livrariavirtual.api.dtos.BookDTO;

@Entity
public class Book 
{
	private Integer id;
	private String title;
	private String language;
	private String ISBN10Code;
	private String ISBN13Code;
	private List<Author> authors;
	private Publisher publisher;
	private String edition;
	private String productDimensions;
	private Double shippingWeight;
	private Integer averageCustomerReview;
	private Double bestSellerRank;
	private Double price; 
	
	public Book() {	}
	
	public Book(Integer id, String title, String language, String ISBN10Code, String ISBN13Code,
			List<Author> authors, Publisher publisher, String edition, String productDimensions, Double shippingWeight,
			Integer averageCustomerReview, Double bestSellerRank, Double price) {
		this.id = id;
		this.title = title;
		this.language = language;
		this.ISBN10Code = ISBN10Code;
		this.ISBN13Code = ISBN13Code;
		this.authors = authors;
		this.publisher = publisher;
		this.edition = edition;
		this.productDimensions = productDimensions;
		this.shippingWeight = shippingWeight;
		this.averageCustomerReview = averageCustomerReview;
		this.bestSellerRank = bestSellerRank;
		this.price = price;
	}
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "language", nullable = false)
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "ISBN10", nullable = false)
	public String getISBN10Code() {
		return ISBN10Code;
	}
	public void setISBN10Code(String iSBN10Code) {
		ISBN10Code = iSBN10Code;
	}

	@Column(name = "ISBN13", nullable = false)
	public String getISBN13Code() {
		return ISBN13Code;
	}
	public void setISBN13Code(String iSBN13Code) {
		ISBN13Code = iSBN13Code;
	}

	@ManyToMany(mappedBy = "books")
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@ManyToOne
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Column(name = "edition", nullable = false)
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}


	@Column(name = "dimensions", nullable = false)
	public String getProductDimensions() {
		return productDimensions;
	}
	public void setProductDimensions(String productDimensions) {
		this.productDimensions = productDimensions;
	}

	@Column(name = "weight", nullable = false)
	public Double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}


	@Column(name = "averageCustomerReview", nullable = false)
	public Integer getAverageCustomerReview() {
		return averageCustomerReview;
	}
	public void setAverageCustomerReview(Integer averageCustomerReview) {
		this.averageCustomerReview = averageCustomerReview;
	}

	@Column(name = "bestSellerRank", nullable = false)
	public Double getBestSellerRank() {
		return bestSellerRank;
	}
	public void setBestSellerRank(Double bestSellerRank) {
		this.bestSellerRank = bestSellerRank;
	}


	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


	@Transient
	public static List<BookDTO> convertToDTO(List<Book> books) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
