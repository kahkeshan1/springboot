package io.stars.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId);
	
	//get all courses by name
	public List<Course> findByName(String name);
}


/*CrudRepository is a generic type. needs two arguments - first is the entity class type, second
is the type of the id.
We need a method which takes a topic id and returns the list of courses that belong to it. As we have used
in topic courseRepository.findAll() would return all courses, but we want to be filtered by topicId. So In the Crud Repository
interface we declare a method somewhat like - public List<Course> getCoursesByTopic(String topicId); If method is declared in a particular way, spring has the ability
to decide what on what data records need to be filtered. Since, we have defined CrudRepository of type Course, spring already knows course records need to be
fetched. It needs just to decide the filter.

structure to declare custom methods so that spring is able to recognize it.
1.starts with find
2.then By
3.the filter variable name

so to getAllCourses by name - we need to define name as
	public List<Course> findByName(String name) - we dont need to provide any further implementation and spring handles everything for us.
 Similarly to get all courses b description we can declare method  - findByDescription(String description)
 
For all courses of a particular topic we need to specify the property of topic object which is used to filter
so to get all courses by topic where key is topic id, we can write
	findByTopicId(String topicId)
  */
