package com.example.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// https://spring.io/guides/gs/accessing-data-jpa/
// store Customer objects, each annotated as a JPA entity.

@Entity
@Getter @Setter @ToString
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	protected Customer() {}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return String.format("id: %d, first name: %s, last name: %s", id, firstName, lastName);
	}

}

// The default constructor exists only for the sake of JPA. 
// You do not use it directly, so it is designated as protected. 

// The other constructor is the one you use to create instances of Customer to be saved to the database.

// The Customer class is annotated with @Entity, indicating that it is a JPA entity. 
// (Because no @Table annotation exists, it is assumed that this entity is mapped to a table named Customer.)

// The Customer object’s id property is annotated with @Id so that JPA recognizes it as the object’s ID. 
// The id property is also annotated with @GeneratedValue to indicate that the ID should be generated automatically.

// The other two properties, firstName and lastName, are left unannotated. 
// It is assumed that they are mapped to columns that share the same names as the properties themselves.
