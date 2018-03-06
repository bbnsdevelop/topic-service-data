package br.com.topicservicedata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.topicservicedata.entities.Topic;

@Repository
public interface TopicRepository  extends CrudRepository<Topic, String>{
	
	@Query("select t from Topic t where t.categoria = :categoria")
	List<Topic> findByCategory(@Param("categoria") String categoria);

}
