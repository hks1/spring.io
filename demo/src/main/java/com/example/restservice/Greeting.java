package com.example.restservice;

// https://spring.io/guides/gs/rest-service/
// Create a Resource Representation Class (to model the greeting representation)
// To do so, provide a plain old Java object with fields, constructors, and accessors for the id and content data
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Greeting {
	
	private final long id;
	private final String content;
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

}


/*

This application uses the Jackson JSON library to automatically marshal instances of type 
Greeting into JSON. 
Jackson is included by default by the web starter.
*/