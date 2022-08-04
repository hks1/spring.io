package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// You also need an additional class, to embed the inner quotation itself.
/*
 * {
   type: "success",
   value: {
      id: 10,
      quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
   }
}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter @NoArgsConstructor @ToString
public class Value {
	
	private Long id;
	private String quote;

}
