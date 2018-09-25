package br.pucminas.livrariavirtual.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	private Integer id;
	private String fullName;
	private String countryRegion;
	private String streetAddress;
	private String city;
	private String stateProvinceRegion;
	private String zipCode;
	private String deliveryInstructions;
	
	public Address() {}
	
	public Address(Integer id, String fullName, String countryRegion, String streetAddress, String city, String stateProvinceRegion, 
			String zipCode, String deliveryInstructions) {
		this.id = id;
		this.fullName = fullName;
		this.countryRegion = countryRegion;
		this.streetAddress = streetAddress;
		this.city = city;
		this.stateProvinceRegion = stateProvinceRegion;
		this.zipCode = zipCode;
		this.deliveryInstructions = deliveryInstructions;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "fullName", nullable = false)
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name = "countryRegion", nullable = false)
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	
	@Column(name = "streetAddress", nullable = false)
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "stateProvinceRegion", nullable = false)
	public String getStateProvinceRegion() {
		return stateProvinceRegion;
	}
	public void setStateProvinceRegion(String stateProvinceRegion) {
		this.stateProvinceRegion = stateProvinceRegion;
	}
	
	@Column(name = "zipCode", nullable = false)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name = "deliveryInstructions")
	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}
	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}
	
}
