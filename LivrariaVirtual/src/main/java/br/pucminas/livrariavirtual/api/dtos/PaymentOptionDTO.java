package br.pucminas.livrariavirtual.api.dtos;

import java.util.Calendar;

import br.pucminas.livrariavirtual.api.enums.CardTypeEnum;

public class PaymentOptionDTO {

	private Long id;
	private CustomerDTO customer;
	private String nameOnCard;
	private String cardNumber;
	private Calendar expirationDate;
	private CardTypeEnum cartType;
	
	public PaymentOptionDTO(Long id, CustomerDTO customer, String nameOnCard, String cardNumber,
			Calendar expirationDate, CardTypeEnum cartType) {
		this.id = id;
		this.customer = customer;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cartType = cartType;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Calendar getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}
	public CardTypeEnum getCartType() {
		return cartType;
	}
	public void setCartType(CardTypeEnum cartType) {
		this.cartType = cartType;
	}
	
}
