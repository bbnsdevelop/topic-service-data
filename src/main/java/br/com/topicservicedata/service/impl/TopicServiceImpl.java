package br.com.topicservicedata.service.impl;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.topicservicedata.entities.Topic;
import br.com.topicservicedata.exception.TopicException;
import br.com.topicservicedata.repositories.TopicRepository;
import br.com.topicservicedata.rest.request.TopicRequest;
import br.com.topicservicedata.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicRepository topicRepository;
		
	private static Logger logger = Logger.getLogger(TopicServiceImpl.class);
	
	private Boolean deleteTopic(Long id) {
		if(isNull(id)) {
			topicRepository.deleteById(id);
			return true;
		}
		return false;
	}
	private List<Topic> getByCategory(String categoria){
		List<Topic> topicList =  new ArrayList<>();
		try {
			if(!isNull(categoria)) {	
				topicRepository.findByCategory(categoria).forEach(topicList::add);
				/* modo antigo
				 * topics.stream().filter(t -> t.getCategoria().equals(categoria)).forEach(t ->{
					Topic topic = new Topic(t.getId(), t.getNome(), t.getDescription(), t.getCategoria());
					topicList.add(topic);
				});*/
			}
			if(topicList.isEmpty()) {
				throw new TopicException("Houve um problema ao carregar a categoria: "+ categoria);
			}
		} catch (TopicException e) {
			logger.error(e.getMessage());
		}		
		
		return topicList;
		
	}
	private Topic upDateTopicService(TopicRequest request, Long id) {
		if(TopicBydId(id) == null) {
			throw new TopicException("Não exixte o id informado para atualizar: " + id);
		}
		else {
			logger.info("Atualizando o topic de id: " + id);
			Topic topic = getTopic(id);
			topicRepository.save(topic);			
		}
		return null;
	}
	private Topic TopicBydId(Long id) {
		logger.info("buscar topic pelo id: "+ id);
		if(isNull(id)) {
			throw new TopicException("Não existe o id informado: " + id);
		}
		return topicRepository.findById(id).get();
		//return topics.stream().filter(t ->	t.getId().equals(id)).findFirst().orElse(null);
	}
	private Boolean addTopicService(Topic topic) {
		if(!isNull(topic.getNome())){
		topicRepository.save(topic);
			return true;
		}		
		return false;
	}
	
	// metodos publicos de acesso via interface
	
	public List<Topic> getAll(){
		logger.info("get all topics: " + "url /topics");
		List<Topic>  topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	public Topic getTopic(Long id) {
		try {
			Topic topicById = TopicBydId(id);
			if(topicById != null) {
				return topicById;
			}else {
				throw new TopicException("Erro ao buscar topic com id: " + id);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	public void create(List<TopicRequest> topicsRequeste) {
		if(!topicsRequeste.isEmpty()) {
			topicsRequeste.stream().forEach(t -> {
				Boolean add = addTopicService(new Topic(t.getNome(), t.getDescription(), t.getCategoria()));
				if(add) {
					logger.info("topic adicionado com sucesso: " + t.getId());
				}
				else {
					throw new TopicException("Erro ao adicionado topic");
				}
			});			
		}
	}
	public Topic upDateTopic(TopicRequest topicUpDate, Long id) {
		Topic topic = upDateTopicService(topicUpDate, id);
		if(topic != null) {
			return topic;
		}
		return null;
	}
	public List<Topic> getCategory(String categoria) {
		return getByCategory(categoria);
	}
	public void delete(Long id) {
		Boolean delete = deleteTopic(id);
		if(delete) {
			logger.info("topic deletado com sucesso: " + id);
		}else {
			throw new TopicException("Erro ao deletar topic, id: "+ id);
		}
	}

}
