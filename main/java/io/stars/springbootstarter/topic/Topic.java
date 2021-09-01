package io.stars.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  			//@Entity-with this jpa knows to create a table Topic with member variables as columns
public class Topic {

	@Id
	private String id; //id is annotated with @Id . acts as a primary key in db
	private String name;
	private String description;
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
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	} 
}
