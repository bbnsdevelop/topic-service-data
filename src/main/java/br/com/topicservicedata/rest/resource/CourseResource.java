package br.com.topicservicedata.rest.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.topicservicedata.rest.request.CourseRequest;
import br.com.topicservicedata.rest.response.CourseResponse;


public interface CourseResource {
	
		public ResponseEntity<List<CourseResponse>> getAllTopic(Long topicId);
		public ResponseEntity<CourseResponse> getTopic(Long id); 
		public ResponseEntity<List<CourseResponse>> getTopicByCategory(String categoria);
		public ResponseEntity<?> addTopic(List<CourseRequest> topics, Long topicId);
		public ResponseEntity<CourseResponse> upDateTopic(CourseRequest request);
		public ResponseEntity<?> deleteTopic(Long id);

}
