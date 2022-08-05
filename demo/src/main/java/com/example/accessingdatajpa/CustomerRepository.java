package com.example.accessingdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Creating Simple Queries
// Spring Data JPA focuses on using JPA to store data in a relational database. 
// Its most compelling feature is the ability to create repository implementations automatically, at runtime, from a repository interface.

// create a repository interface that works with Customer entities

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByLastName(String lastName);
	
	Customer findById(long id);

}

// CustomerRepository extends the CrudRepository interface. 
// The type of entity and ID that it works with, Customer and Long, 
// are specified in the generic parameters on CrudRepository. 
// By extending CrudRepository, CustomerRepository inherits several methods for working with Customer persistence, 
// including methods for saving, deleting, and finding Customer entities.


// In a typical Java application, you might expect to write a class that implements CustomerRepository. 
// However, that is what makes Spring Data JPA so powerful: 
// You need not write an implementation of the repository interface. 
// Spring Data JPA creates an implementation when you run the application.

/*
 * @SpringBootApplication is a convenience annotation that adds all of the following:

@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
*/
