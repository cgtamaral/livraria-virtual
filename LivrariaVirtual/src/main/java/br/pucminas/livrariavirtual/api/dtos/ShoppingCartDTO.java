package br.pucminas.livrariavirtual.api.dtos;

import java.util.List;

public class ShoppingCartDTO {
	
	private Long id;
	private List<ShoppingCartItemDTO> itemsShoppingCart;
	private Double subtotal;
	
	public ShoppingCartDTO() {}
	
	
	public ShoppingCartDTO(Long id, List<ShoppingCartItemDTO> itemsShoppingCart, Double subtotal) {
		this.id = id;
		this.itemsShoppingCart = itemsShoppingCart;
		this.subtotal = subtotal;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ShoppingCartItemDTO> getItemsShoppingCart() {
		return itemsShoppingCart;
	}
	public void setItemsShoppingCart(List<ShoppingCartItemDTO> itemsShoppingCart) {
		this.itemsShoppingCart = itemsShoppingCart;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}
