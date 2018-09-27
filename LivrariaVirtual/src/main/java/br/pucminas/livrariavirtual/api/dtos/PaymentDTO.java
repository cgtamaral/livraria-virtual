package br.pucminas.livrariavirtual.api.dtos;

import java.util.Calendar;

public class PaymentDTO {
	
	private Long id;
	private String nameOnCard;
	private String cardNumber;
	private Calendar expirationDate;
	private String giftCardOrPromotionalCode;
	private Integer numberOfInstallments;
	
	public PaymentDTO() {}
	
	public PaymentDTO(Long id, String nameOnCard, String cardNumber, Calendar expirationDate,
			String giftCardOrPromotionalCode, Integer numberOfInstallments) {
		super();
		this.id = id;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.giftCardOrPromotionalCode = giftCardOrPromotionalCode;
		this.numberOfInstallments = numberOfInstallments;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getGiftCardOrPromotionalCode() {
		return giftCardOrPromotionalCode;
	}
	public void setGiftCardOrPromotionalCode(String giftCardOrPromotionalCode) {
		this.giftCardOrPromotionalCode = giftCardOrPromotionalCode;
	}
	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}
	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
}
