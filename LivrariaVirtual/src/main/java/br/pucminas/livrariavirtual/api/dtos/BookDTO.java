package br.pucminas.livrariavirtual.api.dtos;

import java.util.List;

public class BookDTO {
	
	private Long id;
	private String title;
	private String language;
	private String ISBN10Code;
	private String ISBN13Code;
	private List<AuthorDTO> authors;
	private PublisherDTO publisher;
	private String edition;
	private String productDimensions;
	private Double shippingWeight;
	private String unitMeasure;
	private Integer averageCustomerReview;
	private Double bestSellerRank;
	private Double price; 
	private List<BookReviewDTO> bookReviews;
	
	
	public BookDTO(Long id, String title, String language, String iSBN10Code, String iSBN13Code,
			List<AuthorDTO> authors, PublisherDTO publisher, String edition, String productDimensions,
			Double shippingWeight, String unitMeasure, Integer averageCustomerReview, Double bestSellerRank,
			Double price, List<BookReviewDTO> bookReviews) {
		this.id = id;
		this.title = title;
		this.language = language;
		ISBN10Code = iSBN10Code;
		ISBN13Code = iSBN13Code;
		this.authors = authors;
		this.publisher = publisher;
		this.edition = edition;
		this.productDimensions = productDimensions;
		this.shippingWeight = shippingWeight;
		this.unitMeasure = unitMeasure;
		this.averageCustomerReview = averageCustomerReview;
		this.bestSellerRank = bestSellerRank;
		this.price = price;
		this.bookReviews = bookReviews;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getISBN10Code() {
		return ISBN10Code;
	}
	public void setISBN10Code(String iSBN10Code) {
		ISBN10Code = iSBN10Code;
	}
	public String getISBN13Code() {
		return ISBN13Code;
	}
	public void setISBN13Code(String iSBN13Code) {
		ISBN13Code = iSBN13Code;
	}
	public List<AuthorDTO> getAuthors() {
		return authors;
	}
	public void setAuthors(List<AuthorDTO> authors) {
		this.authors = authors;
	}
	public PublisherDTO getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherDTO publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getProductDimensions() {
		return productDimensions;
	}
	public void setProductDimensions(String productDimensions) {
		this.productDimensions = productDimensions;
	}
	public Double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	public String getUnitMeasure() {
		return unitMeasure;
	}
	public void setUnitMeasure(String unitMeasure) {
		this.unitMeasure = unitMeasure;
	}
	public Integer getAverageCustomerReview() {
		return averageCustomerReview;
	}
	public void setAverageCustomerReview(Integer averageCustomerReview) {
		this.averageCustomerReview = averageCustomerReview;
	}
	public Double getBestSellerRank() {
		return bestSellerRank;
	}
	public void setBestSellerRank(Double bestSellerRank) {
		this.bestSellerRank = bestSellerRank;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<BookReviewDTO> getBookReviews() {
		return bookReviews;
	}
	public void setBookReviews(List<BookReviewDTO> bookReviews) {
		this.bookReviews = bookReviews;
	}
}
