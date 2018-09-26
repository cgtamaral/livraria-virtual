package br.pucminas.livrariavirtual.api.dtos;

import java.util.Calendar;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BookReviewDTO
{
	private Long id;
	private String book;
	private Long customerId;
	private String customer;
	private Integer stars;
	private String title;
	private String comment;
	private Calendar reviewDate;
	
	public BookReviewDTO() {}
	
	public BookReviewDTO(Long id, String book, Long customerId, String customer, Integer stars, String title, String comment,
			Calendar reviewDate) {

		this.id = id;
		this.book = book;
		this.customerId = customerId;
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
	
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	@NotEmpty(message = "O titulo do comentário deve ser informado!")
	@Length(min = 3, max = 255, message = "O titulo do comentário deve ser um texto entre 10 e 255 caracters!")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@NotEmpty(message = "O comentário deve ser informado!")
	@Length(min = 10, max = 1000, message = "O comentário deve ser um texto entre 50 e 1000 caracters!")
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
