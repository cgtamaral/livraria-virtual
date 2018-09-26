package br.pucminas.livrariavirtual.api.dtos;

public class AuthorDTO {
	
	private Integer id;
	private String name;
	private String biography;

	
	public AuthorDTO() {}
	
		
	public AuthorDTO(Integer id, String name, String biography) {
		this.id = id;
		this.name = name;
		this.biography = biography;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
}
