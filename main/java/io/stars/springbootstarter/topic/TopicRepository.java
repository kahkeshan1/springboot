package io.stars.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
	
	
}


//CrudRepository is a generic type. needs two arguments - first is the entity class type, second
//is the type of the id.