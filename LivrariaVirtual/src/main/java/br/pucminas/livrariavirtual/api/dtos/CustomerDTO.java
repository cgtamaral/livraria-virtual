package br.pucminas.livrariavirtual.api.dtos;

import java.util.List;

import br.pucminas.livrariavirtual.api.entities.User;

public class CustomerDTO {
	
	private Long id;
	private User user;
	private List<AddressDTO> addresses;
	private List<PaymentOptionDTO> paymentOptions;
	private List<OrderDTO> orders;
	
	public CustomerDTO() {}
	
	public CustomerDTO(Long id, User user, List<AddressDTO> addresses, List<PaymentOptionDTO> paymentOptions,
			List<OrderDTO> orders) {
		super();
		this.id = id;
		this.user = user;
		this.addresses = addresses;
		this.paymentOptions = paymentOptions;
		this.orders = orders;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	public List<PaymentOptionDTO> getPaymentOptions() {
		return paymentOptions;
	}
	public void setPaymentOptions(List<PaymentOptionDTO> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	public List<OrderDTO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}
}
