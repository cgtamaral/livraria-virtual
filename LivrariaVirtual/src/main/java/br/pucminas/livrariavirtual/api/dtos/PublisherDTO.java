package br.pucminas.livrariavirtual.api.dtos;

public class PublisherDTO {
	
	private Integer id;
	private String name;
	private String about;

	
	public PublisherDTO() {}
	
	public PublisherDTO(Integer id, String name, String about) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
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
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
}
