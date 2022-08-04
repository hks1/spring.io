package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/rest-service/
// Create a Resource Controller
// In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller.
// These components are identified by the @RestController annotation
// Following class "GreetingController" handles GET requests for /greeting by returning a new instance of the Greeting class:


@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	

}

// The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
// There are companion annotations for other HTTP verbs (e.g. @PostMapping for POST). 
// There is also a @RequestMapping annotation that they all derive from, and can serve as a synonym (e.g. @RequestMapping(method=GET)).

// A key difference between a traditional MVC controller and the RESTful web service controller shown earlier is the way that the HTTP response body is created. 
// Rather than relying on a view technology to perform server-side rendering of the greeting data to HTML, 
// this RESTful web service controller populates and returns a Greeting object. 
// The object data will be written directly to the HTTP response as JSON.

// This code uses Spring @RestController annotation, 
// which marks the class as a controller where every method returns a domain object instead of a view. 
// It is shorthand for including both @Controller and @ResponseBody.

// The Greeting object must be converted to JSON. Thanks to Spring’s HTTP message converter support, 
// you need not do this conversion manually. 
// Because Jackson 2 is on the classpath, 
// Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON.

