package br.com.topicservicedata.rest.request;

public class CourseRequest {
	
	private Long id;
	private String nome;
	private String description;
	private String categoria;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	

}
