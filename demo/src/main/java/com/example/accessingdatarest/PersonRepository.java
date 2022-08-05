package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// https://spring.io/guides/gs/accessing-data-rest/
// Create a Person Repository
// This repository is an interface that lets you perform various operations involving Person objects. 
// It gets these operations by extending the PagingAndSortingRepository interface that is defined in Spring Data Commons.

//At runtime, Spring Data REST automatically creates an implementation of this interface. 
//Then it uses the @RepositoryRestResource annotation to direct Spring MVC to create RESTful endpoints at /people.


@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	
	List<Person> findByLastName(@Param("name") String name);

}

/*
 * 	@RepositoryRestResource is not required for a repository to be exported. 
 * It is used only to change the export details, such as using /people instead of the default value of /persons.
 */

/*
 * @SpringBootApplication is a convenience annotation that adds all of the following:

@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
*/

/*
 * Spring Boot automatically spins up Spring Data JPA to create a concrete implementation of the PersonRepository and configure it to talk to a back end in-memory database by using JPA.
 * */

/*
 * Spring Data REST builds on top of Spring MVC. 
 * It creates a collection of Spring MVC controllers, JSON converters, and other beans to provide a RESTful front end. 
 * These components link up to the Spring Data JPA backend. 
 * When you use Spring Boot, this is all autoconfigured. 
 * If you want to investigate how that works, by looking at the RepositoryRestMvcConfiguration in Spring Data REST.
 * */
