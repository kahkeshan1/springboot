package io.stars.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //added in any class which we need to be a rest controller . 
public class HelloController {     //this means this class can have methods which maps to urls
	
	@RequestMapping("/hello")  //this asks spring to map url request having /hello to it. 
	public String sayHi() {
		return "Hi";
	} 
}

// @RestController  - tells spring this is a class which deals with http request and returns a http response
// @RequestMapping("/hello") - handle request for urls having /hello