package br.pucminas.livrariavirtual.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	private Long id;
	private User user;
	private List<Address> adresses;
	private List<PaymentOption> paymentOptions;
	private List<Order> orders;

	public Customer() {}
	
	public Customer(Long id,User user,
			List<Address> adresses, List<PaymentOption> paymentOptions, List<Order> orders) {
		this.id = id;
		this.user = user;
		this.adresses = adresses;
		this.paymentOptions = paymentOptions;
		this.orders = orders;
	}
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
    @JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<PaymentOption> getPaymentOptions() {
		return paymentOptions;
	}
	public void setPaymentOptions(List<PaymentOption> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
