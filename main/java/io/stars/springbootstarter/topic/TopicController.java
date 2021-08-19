package io.stars.springbootstarter.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
public class TopicController {
 
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() { 
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{var}")
	public Topic getTopic(@PathVariable("var") String id) { //maps var to id . can just use @PathVariable String id - if variable name and arguement name is same
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics") //by default  method is post. value specifies - map any request that is post to /topics
	public void addTopic(@RequestBody Topic topic) //tells spring to map the json in post request to a Topic
	{
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		
		topicService.deleteTopic(id);
	}
}

//when there is a /topics request . it executes the above method, it converts the returned List<Topic> object automatically
//to json