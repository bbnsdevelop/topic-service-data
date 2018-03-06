package br.com.topicservicedata.service;

import java.util.List;

import br.com.topicservicedata.rest.request.CourseRequest;
import br.com.topicservicedata.rest.response.CourseResponse;

public interface CourseService {
	
	public List<CourseResponse> getAll();
	public CourseResponse getCourse(Long id);
	public List<CourseResponse> getCategory(String categoria);
	public void create(List<CourseRequest> Courses);
	public CourseResponse upDateCourse(CourseRequest request);
	public void delete(Long id);
	
}
