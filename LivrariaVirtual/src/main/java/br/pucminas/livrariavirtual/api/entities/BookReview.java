package br.pucminas.livrariavirtual.api.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import br.pucminas.livrariavirtual.api.dtos.BookReviewDTO;

@Entity
public class BookReview 
{
	private Long id;
	private Book book;
	private Customer customer;
	private Integer stars;
	private String title;
	private String comment;
	private Calendar reviewDate;
	
	public BookReview() {}
	
	public BookReview(Long id, Book book, Customer customer, Integer stars, String title, String comment,
			Calendar reviewDate) {
		this.id = id;
		this.book = book;
		this.customer = customer;
		this.stars = stars;
		this.title = title;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Column(name = "star", nullable = false)
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "comment", length = 4000, nullable = false)
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Column(name = "reviewDate", nullable = false)
	public Calendar getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Calendar reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Transient
	public static BookReviewDTO convertToDTO(List<BookReview> bookReviews) {
		// TODO Auto-generated method stub
		return null;
	}
}
