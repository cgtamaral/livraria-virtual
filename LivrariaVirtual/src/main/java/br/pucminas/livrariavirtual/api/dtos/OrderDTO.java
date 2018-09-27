package br.pucminas.livrariavirtual.api.dtos;

import br.pucminas.livrariavirtual.api.enums.OrderStatusEnum;

public class OrderDTO 
{
	private Long id;
	private Long customerId;
	private OrderStatusEnum orderStatusEnum;
	private ShoppingCartDTO shoppingCart;
	private DeliveryDTO delivery;
	private Double subTotal;
	
	public OrderDTO() {}
	
	public OrderDTO(Long id, Long customerId, OrderStatusEnum orderStatusEnum, ShoppingCartDTO shoppingCart, DeliveryDTO delivery,
			Double subTotal) {
		this.id = id;
		this.orderStatusEnum = orderStatusEnum;
		this.shoppingCart = shoppingCart;
		this.delivery = delivery;
		this.subTotal = subTotal;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public OrderStatusEnum getOrderStatusEnum() {
		return orderStatusEnum;
	}
	public void setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
		this.orderStatusEnum = orderStatusEnum;
	}
	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public DeliveryDTO getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryDTO delivery) {
		this.delivery = delivery;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
