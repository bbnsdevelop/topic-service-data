package br.com.topicservicedata.builder;

import br.com.topicservicedata.rest.response.CourseResponse;

public class CourseResponseBuilder {
	
	private Long id;
	private String nome;
	private String description;
	private String categoria;
	
	public static CourseResponseBuilder create() {
		return new CourseResponseBuilder();
	}
	
	public CourseResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public CourseResponseBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	public CourseResponseBuilder description(String description) {
		this.description = description;
		return this;
	}
	public CourseResponseBuilder categoria(String categoria) {
		this.categoria = categoria;
		return this;
	}
	
	public CourseResponse build() {
		CourseResponse courseResponse = new CourseResponse();
		courseResponse.setId(id);
		courseResponse.setNome(nome);
		courseResponse.setDescription(description);
		courseResponse.setCategoria(categoria);		
		return courseResponse;
		
	}
	
	
}
