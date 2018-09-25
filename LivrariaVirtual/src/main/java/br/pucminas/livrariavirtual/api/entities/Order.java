package br.pucminas.livrariavirtual.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.pucminas.livrariavirtual.api.enums.OrderStatusEnum;

@Entity
public class Order 
{
	private Long id;
	private OrderStatusEnum orderStatusEnum;
	private ShoppingCart shoppingCart;
	private Delivery delivery;
	private Double subTotal;
	
	public Order() {}
	
	public Order(Long id, OrderStatusEnum orderStatusEnum, ShoppingCart shoppingCart, Delivery delivery,
			Double subTotal) {
		this.id = id;
		this.orderStatusEnum = orderStatusEnum;
		this.shoppingCart = shoppingCart;
		this.delivery = delivery;
		this.subTotal = subTotal;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	public OrderStatusEnum getOrderStatusEnum() {
		return orderStatusEnum;
	}
	public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
		this.orderStatusEnum = orderStatusEnum;
	}
	
	@OneToOne
	@JoinColumn(name = "shoppingCart_id", nullable = false)
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@OneToOne
	@JoinColumn(name = "delivery_id", nullable = false)
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	@Column(name = "subTotal", nullable = false)
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
}
