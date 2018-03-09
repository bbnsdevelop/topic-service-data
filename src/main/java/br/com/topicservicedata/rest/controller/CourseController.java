package br.com.topicservicedata.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.topicservicedata.rest.request.CourseRequest;
import br.com.topicservicedata.rest.resource.CourseResource;
import br.com.topicservicedata.rest.response.CourseResponse;
import br.com.topicservicedata.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController implements CourseResource {
	
	@Inject
	private CourseService courseService;
	
	@Override
	@RequestMapping(value ="/{topicId}/find-all", method = RequestMethod.GET)
	public ResponseEntity<List<CourseResponse>> getAllTopic(@PathVariable("topicId") Long topicId) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.getAll(topicId));
	}

	@Override
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseResponse> getTopic(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourse(id));
	}

	@Override
	@RequestMapping(value ="/category/{categoria}", method = RequestMethod.GET)
	public ResponseEntity<List<CourseResponse>> getTopicByCategory(String categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.getCategory(categoria));
	}

	@Override
	@RequestMapping(value = "/add/{topicId}/courses", method = RequestMethod.POST)
	public ResponseEntity<?> addTopic(@RequestBody List<CourseRequest> topics, @PathVariable("topicId") Long topicId) {
		courseService.create(topics, topicId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@RequestMapping(value = "/update/topic/{topicId}", method = RequestMethod.PUT)
	public ResponseEntity<CourseResponse> upDateTopic(@RequestBody CourseRequest request, @PathVariable("topicId") Long topicId) {
		return ResponseEntity.status(HttpStatus.OK).body(courseService.upDateCourse(request,  topicId));
	}

	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTopic(@PathVariable("id") Long id) {
		courseService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
