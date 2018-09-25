package br.pucminas.livrariavirtual.api.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart 
{
	private Long id;
	private List<ItemShoppingCart> itemsShoppingCart;
	private Double subtotal;
	
	public ShoppingCart() {}
	
	public ShoppingCart(Long id, List<ItemShoppingCart> itemsShoppingCart, Double subtotal) {
		this.id = id;
		this.itemsShoppingCart = itemsShoppingCart;
		this.subtotal = subtotal;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany
	public List<ItemShoppingCart> getItemsShoppingCart() {
		return itemsShoppingCart;
	}
	public void setItemsShoppingCart(List<ItemShoppingCart> itemsShoppingCart) {
		this.itemsShoppingCart = itemsShoppingCart;
	}
	
	@Column(name = "subTotal", nullable = false)
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}
