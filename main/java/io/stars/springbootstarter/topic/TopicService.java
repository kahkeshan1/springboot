package io.stars.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService { 
	
	@Autowired
	private TopicRepository topicRepository;  
	
	public List<Topic> getAllTopics(){ 
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add); //getting all instances from the table.does everything.connect->fetch->convert .find All returns an iterable
		return topics;
	}
	
	public Topic getTopic(String id) { //id is the primary key
		
		Optional<Topic> optionalTopic = topicRepository.findById(id);
		Topic topic = new Topic();
		if(optionalTopic.isPresent())
			topic = optionalTopic.get();
		return topic;
			 
	}
 
	public void addTopic(Topic topic) { 
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {

		topicRepository.save(topic); //repository checks if there is an id. if yes then updates it, otherwise inserts
	}

	public void deleteTopic(String id) {
		
		topicRepository.deleteById(id);
	} 
}
