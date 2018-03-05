package br.com.topicservicedata.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.topicservicedata.entities.Topic;

@Repository
public interface TopicRepository  extends CrudRepository<Topic, String>{

}
