package br.com.topicservicedata.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.topicservicedata.entities.Topic;
import br.com.topicservicedata.rest.request.TopicRequest;
import br.com.topicservicedata.service.TopicService;

//Aula 27 minuto 5:15


@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
		
		return topicService.getAll();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	@RequestMapping("/topics/category/{categoria}")
	public List<Topic> getTopicByCategory(@PathVariable("categoria") String categoria) {
		return topicService.getCategory(categoria);
	}
	
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public ResponseEntity<?> addTopic(@RequestBody TopicRequest topic){
		topicService.addTopic(topic);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value = "/topics/{id}",  method = RequestMethod.PUT)
	public Topic upDateTopic(@PathVariable("id") String id, @RequestBody TopicRequest topicUpDate) {
		
		return topicService.upDateTopic(topicUpDate, id);
	}
	@RequestMapping(value = "/topics/{id}",  method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("id") String id) {
		
		topicService.delete(id);
	}
}
