package io.stars.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.stars.springbootstarter.topic.Topic;

@Entity  			//@Entity-with this jpa knows to create a table Course with member variables as columns 
public class Course {
	@Id
	private String id; //id is annotated with @Id . acts as a primary key in db
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String id, String name, String description, String topicId ) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	 
}
