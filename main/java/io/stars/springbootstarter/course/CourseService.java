package io.stars.springbootstarter.course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService { 
	
	@Autowired
	private CourseRepository courseRepository;  
	
	public List<Course> getAllCourses(String topicId){ 
		
		List<Course> courses = new ArrayList<>(); 
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) { //id is the primary key
		 
		Optional<Course> optionalCourse = courseRepository.findById(id);
		Course course = new Course();
		if(optionalCourse.isPresent())
			course = optionalCourse.get();
		return course;
			 
	}
	
	public List<Course> getCourseByName(String name) {
		
		return courseRepository.findByName(name);  //findByName() is our custom method which we have named as per spring recommendation so that spring is able to handle its implementation just like we can use 
	}
 
	public void addCourse(Course course) { 
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {

		courseRepository.save(course); //repository checks if there is an id. if yes then updates it, otherwise inserts
	}

	public void deleteCourse(String id) {
		
		courseRepository.deleteById(id);
	} 
}
