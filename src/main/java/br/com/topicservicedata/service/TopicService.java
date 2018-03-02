package br.com.topicservicedata.service;

import java.util.List;

import br.com.topicservicedata.entities.Topic;
import br.com.topicservicedata.rest.request.TopicRequest;

public interface TopicService {
	
	public List<Topic> getAll();
	public Topic getTopic(String id);
	public List<Topic> getCategory(String categoria);
	public void addTopic(TopicRequest topic);
	public Topic upDateTopic(TopicRequest topicUpDate, String id);
	public void delete(String id);
		
}
