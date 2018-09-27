package br.pucminas.livrariavirtual.api.dtos;

import br.pucminas.livrariavirtual.api.entities.Book;

public class ShoppingCartItemDTO {
	
	private Long id;
	private ShoppingCartDTO shoppingCart;
	private Book book;
	private Integer quantity;
	
	public ShoppingCartItemDTO(Long id, ShoppingCartDTO shoppingCart, Book book, Integer quantity) {
		super();
		this.id = id;
		this.shoppingCart = shoppingCart;
		this.book = book;
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
