package br.pucminas.livrariavirtual.api.dtos;

import java.util.Calendar;

import br.pucminas.livrariavirtual.api.enums.UserProfileEnum;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private String mobilePhoneNumber;
	private String cpf;
	private String password;
	private UserProfileEnum userProfile;
	private Calendar dateRegister;
	
	public UserDTO(Long id, String name, String email, String mobilePhoneNumber, String cpf, String password,
			UserProfileEnum userProfile, Calendar dateRegister) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.cpf = cpf;
		this.password = password;
		this.userProfile = userProfile;
		this.dateRegister = dateRegister;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserProfileEnum getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfileEnum userProfile) {
		this.userProfile = userProfile;
	}
	public Calendar getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}
}
