package br.com.topicservicedata.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.topicservicedata.builder.CourseBuilder;
import br.com.topicservicedata.builder.CourseRequestBuilder;
import br.com.topicservicedata.builder.CourseResponseBuilder;
import br.com.topicservicedata.entities.Course;
import br.com.topicservicedata.exception.CourseException;
import br.com.topicservicedata.repositories.CourseRepository;
import br.com.topicservicedata.rest.request.CourseRequest;
import br.com.topicservicedata.rest.response.CourseResponse;
import br.com.topicservicedata.service.CourseService;

@Service
public class CourseImpl implements CourseService {
	
	@Inject
	private CourseRepository courseRepository;

	@Override
	public List<CourseResponse> getAll() {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findAll().forEach(courseList::add);
		List<CourseResponse> responseList =  new ArrayList<>();
		if(!courseList.isEmpty()) {
			courseList.stream().forEach(c ->{
				CourseResponseBuilder builder = CourseResponseBuilder.create()
						.id(c.getId())
						.nome(c.getNome())
						.description(c.getDescription())
						.categoria(c.getCategoria());
				responseList.add(builder.build());
			});
			return responseList;
		}
		return null;
	}

	@Override
	public CourseResponse getCourse(Long id) {
		Course course = courseRepository.findById(id).get(); 
		CourseResponseBuilder response = CourseResponseBuilder.create()
				 .id(course.getId())
				 .nome(course.getNome())
				 .description(course.getDescription())
				 .categoria(course.getCategoria());
		 return response.build();
	}

	@Override
	public List<CourseResponse> getCategory(String categoria) {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findByCategoria(categoria).forEach(courseList::add);
		List<CourseResponse> responseList =  new ArrayList<>();
		if(courseList.isEmpty()) {
			throw new CourseException("Erro ao buscar course por categoria");
		}else {
			courseList.stream().forEach(c ->{
				CourseResponseBuilder builder = CourseResponseBuilder.create()
						.id(c.getId())
						.nome(c.getNome())
						.description(c.getDescription())
						.categoria(c.getCategoria());
				responseList.add(builder.build());
			});
			return responseList;
		}		
	}

	@Override
	public void create(List<CourseRequest> Courses) {
		
		Courses.stream().forEach(c ->{
			CourseBuilder builder = CourseBuilder.create()
					.nome(c.getNome())
					.description(c.getDescription())
					.categoria(c.getCategoria());
			courseRepository.save(builder.build());
		});		
	}

	@Override
	public CourseResponse upDateCourse(CourseRequest request) {
		CourseRequestBuilder builder = CourseRequestBuilder.create()
				.id(request.getId())
				.nome(request.getNome())
				.description(request.getDescription())
				.categoria(request.getCategoria());
		 Course course = courseRepository.save(builder.build());
		 CourseResponseBuilder response = CourseResponseBuilder.create()
				 .id(course.getId())
				 .nome(course.getNome())
				 .description(course.getDescription())
				 .categoria(course.getCategoria());
		 return response.build();
	}

	@Override
	public void delete(Long id) {
		courseRepository.deleteById(id);		
	}
	

}
