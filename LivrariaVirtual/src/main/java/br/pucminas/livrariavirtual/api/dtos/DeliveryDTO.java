package br.pucminas.livrariavirtual.api.dtos;

import br.pucminas.livrariavirtual.api.enums.DeliveryStatusEnum;
import br.pucminas.livrariavirtual.api.enums.DeliveryTypeEnum;

public class DeliveryDTO {
	
	private Long id;
	private AddressDTO deliveryAddress;
	private DeliveryTypeEnum deliveryTypeEnum;
	private DeliveryStatusEnum deliveryStatusEnum;
	private PaymentDTO payment;
	private Double price;
		
	
	public DeliveryDTO(Long id, AddressDTO deliveryAddress, DeliveryTypeEnum deliveryTypeEnum,
			DeliveryStatusEnum deliveryStatusEnum, PaymentDTO payment, Double price) {
		this.id = id;
		this.deliveryAddress = deliveryAddress;
		this.deliveryTypeEnum = deliveryTypeEnum;
		this.deliveryStatusEnum = deliveryStatusEnum;
		this.payment = payment;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AddressDTO getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(AddressDTO deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public DeliveryTypeEnum getDeliveryTypeEnum() {
		return deliveryTypeEnum;
	}
	public void setDeliveryTypeEnum(DeliveryTypeEnum deliveryTypeEnum) {
		this.deliveryTypeEnum = deliveryTypeEnum;
	}
	public DeliveryStatusEnum getDeliveryStatusEnum() {
		return deliveryStatusEnum;
	}
	public void setDeliveryStatusEnum(DeliveryStatusEnum deliveryStatusEnum) {
		this.deliveryStatusEnum = deliveryStatusEnum;
	}
	public PaymentDTO getPayment() {
		return payment;
	}
	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
