package br.pucminas.livrariavirtual.api.dtos;

import java.util.Calendar;

import br.pucminas.livrariavirtual.api.entities.Book;

public class BookReviewDTO
{
	private Long id;
	private Book book;
	private CustomerDTO customer;
	private Integer stars;
	private String title;
	private String comment;
	private Calendar reviewDate;
	
	public BookReviewDTO() {}
	
	public BookReviewDTO(Long id, Book book, CustomerDTO customer, Integer stars, String title, String comment,
			Calendar reviewDate) {

		this.id = id;
		this.book = book;
		this.customer = customer;
		this.stars = stars;
		this.title = title;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Calendar getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Calendar reviewDate) {
		this.reviewDate = reviewDate;
	}
}
