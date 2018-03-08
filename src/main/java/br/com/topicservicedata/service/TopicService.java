package br.com.topicservicedata.service;

import java.util.List;

import br.com.topicservicedata.entities.Topic;
import br.com.topicservicedata.rest.request.TopicRequest;

public interface TopicService {
	
	public List<Topic> getAll();
	public Topic getTopic(Long id);
	public List<Topic> getCategory(String categoria);
	public void create(List<TopicRequest> topics);
	public Topic upDateTopic(TopicRequest topicUpDate, Long id);
	public void delete(Long id);
		
}
