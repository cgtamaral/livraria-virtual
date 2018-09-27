package br.pucminas.livrariavirtual.api.dtos;

public class PublisherDTO {
	
	private Long id;
	private String name;
	private String about;

	
	public PublisherDTO() {}
	
	public PublisherDTO(Long id, String name, String about) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
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
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
}
