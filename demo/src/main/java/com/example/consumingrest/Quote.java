package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// https://spring.io/guides/gs/consuming-rest/
// domain class

//Fetching a REST Resource
//from  https://quoters.apps.pcfone.io/api/random
//sample response:
/*
* {
type: "success",
value: {
   id: 10,
   quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
}
}
*/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter @Setter @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	
	private String type;
	private String value;

}

// It is annotated with @JsonIgnoreProperties from the Jackson JSON processing library to indicate that any properties not bound in this type should be ignored.


// To directly bind your data to your custom types, 
// you need to specify the variable name to be exactly the same as the key in the JSON document returned from the API.
// In case your variable name and key in JSON doc do not match, 
// you can use @JsonProperty annotation to specify the exact key of the JSON document.

// consume a REST web service is programmatically
// To help you with that task, Spring provides a convenient template class called RestTemplate. 
// RestTemplate makes interacting with most RESTful services a one-line incantation. 
// And it can even bind that data to custom domain types.

// first create a domain class Quote
