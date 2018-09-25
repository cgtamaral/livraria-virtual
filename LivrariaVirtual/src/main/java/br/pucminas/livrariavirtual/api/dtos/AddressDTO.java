package br.pucminas.livrariavirtual.api.dtos;

public class AddressDTO {
	
	private Integer id;
	private CustomerDTO customer;
	private String fullName;
	private String countryRegion;
	private String streetAddress;
	private String city;
	private String stateProvinceRegion;
	private String zipCode;
	private String deliveryInstructions;
	
	
	public AddressDTO(Integer id, CustomerDTO customer, String fullName, String countryRegion, String streetAddress,
			String city, String stateProvinceRegion, String zipCode, String deliveryInstructions) {
		super();
		this.id = id;
		this.customer = customer;
		this.fullName = fullName;
		this.countryRegion = countryRegion;
		this.streetAddress = streetAddress;
		this.city = city;
		this.stateProvinceRegion = stateProvinceRegion;
		this.zipCode = zipCode;
		this.deliveryInstructions = deliveryInstructions;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvinceRegion() {
		return stateProvinceRegion;
	}
	public void setStateProvinceRegion(String stateProvinceRegion) {
		this.stateProvinceRegion = stateProvinceRegion;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}
	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}
}
