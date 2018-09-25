package br.pucminas.livrariavirtual.api.dtos;

import java.util.List;

public class ShoppingCartDTO {
	
	private Long id;
	private List<ItemShoppingCartDTO> itemsShoppingCart;
	private Double subtotal;
	
	public ShoppingCartDTO(Long id, List<ItemShoppingCartDTO> itemsShoppingCart, Double subtotal) {
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
	public List<ItemShoppingCartDTO> getItemsShoppingCart() {
		return itemsShoppingCart;
	}
	public void setItemsShoppingCart(List<ItemShoppingCartDTO> itemsShoppingCart) {
		this.itemsShoppingCart = itemsShoppingCart;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}
