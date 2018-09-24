package br.pucminas.livrariavirtual.api.entities;

import java.util.List;

public class Customer {

	private String name;
	private String email;
	private String mobilePhoneNumber;
	private String cpf;
	private String password;
	private List<Address> adresses;
	private List<PaymentOption> paymentOptions;
	private List<Order> orders;
	
	
}
