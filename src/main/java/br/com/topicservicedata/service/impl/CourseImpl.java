package br.com.topicservicedata.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import static java.util.Objects.isNull;
import org.springframework.stereotype.Service;

import br.com.topicservicedata.builder.CourseBuilder;
import br.com.topicservicedata.builder.CourseRequestBuilder;
import br.com.topicservicedata.builder.CourseResponseBuilder;
import br.com.topicservicedata.entities.Course;
import br.com.topicservicedata.entities.Topic;
import br.com.topicservicedata.exception.CourseException;
import br.com.topicservicedata.repositories.CourseRepository;
import br.com.topicservicedata.repositories.TopicRepository;
import br.com.topicservicedata.rest.request.CourseRequest;
import br.com.topicservicedata.rest.response.CourseResponse;
import br.com.topicservicedata.service.CourseService;

@Service
public class CourseImpl implements CourseService {
	
	
	private CourseRepository courseRepository;
	private TopicRepository topicRepository;
	
	@Inject
	public CourseImpl(CourseRepository courseRepository, TopicRepository topicRepository) {
		this.courseRepository = courseRepository;
		this.topicRepository = topicRepository;
	}

	@Override
	public List<CourseResponse> getAll(Long topicId) {
		List<Course> courseList = new ArrayList<>();
		
		courseRepository.findBytopicId(topicId).forEach(courseList::add);
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
	public void create(List<CourseRequest> Courses, Long topicId) {
		Topic topic = topicRepository.findById(topicId).get();
		if(topic.getId() == topicId) {
			Courses.stream().forEach(c ->{
				CourseBuilder builder = CourseBuilder.create()
						.nome(c.getName())
						.description(c.getDescription())
						.categoria(c.getCategory())
						.topicId(topic.getId())
						.topicNome(topic.getNome())
						.topicDescription(topic.getDescription())
						.topicCategoria(topic.getCategoria());						
				courseRepository.save(builder.build());
			});			
		}
		else {
			throw new CourseException("Erro ao processar Course");
		}
	}

	@Override
	public CourseResponse upDateCourse(CourseRequest request, Long topicId) {
		if(!request.equals(null)) {
			
			CourseRequestBuilder builder = CourseRequestBuilder.create()
					.id(request.getId())
					.nome(request.getName())
					.description(request.getDescription())
					.categoria(request.getCategory())
					.topicId(topicId);
			Course course = courseRepository.save(builder.build());
			CourseResponseBuilder response = CourseResponseBuilder.create()
					.id(course.getId())
					.nome(course.getNome())
					.description(course.getDescription())
					.categoria(course.getCategoria());
			 return response.build();
		}
		else {
			throw new CourseException("Request enviado nulo");
		}
	}

	@Override
	public void delete(Long id) {
		if(!isNull(id)) {
			courseRepository.deleteById(id);
		}
				
	}
	

}
