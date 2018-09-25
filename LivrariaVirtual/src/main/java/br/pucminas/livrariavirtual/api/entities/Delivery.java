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

import br.pucminas.livrariavirtual.api.enums.DeliveryStatusEnum;
import br.pucminas.livrariavirtual.api.enums.DeliveryTypeEnum;

@Entity
public class Delivery 
{
	private Long id;
	private Address deliveryAddress;
	private DeliveryTypeEnum deliveryTypeEnum;
	private DeliveryStatusEnum deliveryStatusEnum;
	private Payment payment;
	private Double price;
	
	public Delivery() {}
	
	public Delivery(Long id, Address deliveryAddress, DeliveryTypeEnum deliveryTypeEnum,
			DeliveryStatusEnum deliveryStatusEnum, Payment payment, Double price) {
		this.id = id;
		this.deliveryAddress = deliveryAddress;
		this.deliveryTypeEnum = deliveryTypeEnum;
		this.deliveryStatusEnum = deliveryStatusEnum;
		this.payment = payment;
		this.price = price;
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
	@JoinColumn(name = "address_id", nullable = false)
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "deliveryType", nullable = false)
	public DeliveryTypeEnum getDeliveryTypeEnum() {
		return deliveryTypeEnum;
	}
	public void setDeliveryTypeEnum(DeliveryTypeEnum deliveryTypeEnum) {
		this.deliveryTypeEnum = deliveryTypeEnum;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "deliveryStatus", nullable = false)
	public DeliveryStatusEnum getDeliveryStatusEnum() {
		return deliveryStatusEnum;
	}
	public void setDeliveryStatusEnum(DeliveryStatusEnum deliveryStatusEnum) {
		this.deliveryStatusEnum = deliveryStatusEnum;
	}
	
	@OneToOne
	@JoinColumn(name = "payment_id", nullable = false)
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
