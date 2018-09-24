package br.pucminas.livrariavirtual.api.entities;

import java.util.Calendar;

public class Payment {
	
	private String nameOnCard;
	private String cardNumber;
	private Calendar expirationDate;
	private String giftCardOrPromotionalCode;
	private Integer numberOfInstallments;
}
