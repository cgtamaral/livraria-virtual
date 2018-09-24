package br.pucminas.livrariavirtual.api.entities;

import br.pucminas.livrariavirtual.api.enums.OrderStatusEnum;

public class Order 
{
	private Long orderNumber;
	private OrderStatusEnum orderStatusEnum;
	private ShoppingCart shoppingCart;
	private Delivery delivery;
	private Double subTotal;
}
