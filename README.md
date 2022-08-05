# spring.io
spring.io

## demo

~~https://spring.io/quickstart~~</br>
- spring boot
  - import _org.springframework.boot.SpringApplication_;
  - import _org.springframework.boot.autoconfigure.SpringBootApplication_;
  - import _org.springframework.context.annotation.ComponentScan_;
- spring web

@SpringBootApplication is a convenience annotation that adds all of the following:

@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.


~~https://spring.io/guides/gs/rest-service/~~</br>
- Resource Representation Class
  - used Lombok
- Resource Controller
  - _import org.springframework.web.bind.annotation.GetMapping_;
  - _import org.springframework.web.bind.annotation.RequestParam_;
  - _import org.springframework.web.bind.annotation.RestController_;
</br>__Used demo from previous excercise and added component scanning__
</br>@ComponentScan(basePackages = {"com.example.demo", "com.example.restservice"})

~~https://spring.io/guides/gs/consuming-rest/~~</br>
- Fetch a REST Resource
- Create domain class(es)
  - @JsonProperty
  - @JsonIgnoreProperty (imoprt _com.fasterxml.jackson.annotation.JsonIgnoreProperties_)
- Use RestTemplate (_org.springframework.web.client.RestTemplate_)
  - import _org.springframework.boot.web.client.RestTemplateBuilder_
  - @Bean (_org.springframework.context.annotation.Bean_)
	  public RestTemplate restTemplate(RestTemplateBuilder builder) {
		  return builder.build();
	  }
- CommandLineRunner (import _org.springframework.boot.CommandLineRunner_)
  - runs the RestTemplate (and, consequently, fetches the resource) on startup

</br>__Used demo from previous excercise and added component scanning__
</br>@ComponentScan(basePackages = {"com.example.demo", "com.example.restservice", "com.example.consumingrest"})

~~https://spring.io/guides/gs/accessing-data-jpa/~~</br>
- com.example.acccessingdatajpa
- Dependencies
	- Spring Data JPA
	- H2 Database
- Define a Simple Entity
	- import javax.persistence.Entity;
	- import javax.persistence.GeneratedValue;
	- import javax.persistence.GenerationType;
	- import javax.persistence.Id;
	- Store "Customer" objects, each annotated as a JPA entity
- Create Simple Queries
	- Spring Data JPA focuses on using JPA to store data in a relational database. 
	- Its most compelling feature is the ability to create repository implementations automatically, at runtime, from a repository interface.
	- create a repository interface that works with "Customer" entities
		- import org.springframework.data.repository.CrudRepository;

By default, Spring Boot enables JPA repository support and looks in the package (and its subpackages) where @SpringBootApplication is located. If your configuration has JPA repository interface definitions located in a package that is not visible, you can point out alternate packages by using @EnableJpaRepositories and its type-safe basePackageClasses=MyRepository.class parameter.

__Note:__ added AccessDataJpaApplication.java in com.example.accessingdatajpa with main method commented.
without this class, app doesn't come up from DemoApplication class, gives error, CustomerRepository not found.
when demo (@Bean) is executed from DemoApplication class, it prints each row twice because these rows have been already inserted once when called from AccessDataJpaApplication class

[Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
- Spring Data REST takes the features of Spring HATEOAS and Spring Data JPA and automatically combines them together.
- Dependencies
	- Rest Repositories, 
	- Spring Data JPA, and 
	- H2 Database
- Create a Domain Object "Person"
- Create a Person Repository
	- import org.springframework.data.repository.PagingAndSortingRepository;
	- import org.springframework.data.repository.query.Param;
	- import org.springframework.data.rest.core.annotation.RepositoryRestResource;
	- _PagingAndSortingRepository_ is an interface defined in Spring Data Commons.
- At runtime, Spring Data REST automatically creates an implementation of this interface. 
- Then it uses the @RepositoryRestResource annotation to direct Spring MVC to create RESTful endpoints at /people.
- @RepositoryRestResource is not required for a repository to be exported. 
- It is used only to change the export details, such as using /people instead of the default value of /persons.
- Spring Data REST builds on top of Spring MVC. 
- It creates a collection of Spring MVC controllers, JSON converters, and other beans to provide a RESTful front end. 
- These components link up to the Spring Data JPA backend. 
- When you use Spring Boot, this is all autoconfigured. 
- If you want to investigate how that works, by looking at the RepositoryRestMvcConfiguration in Spring Data REST.


Next: refer "See Also" section of https://spring.io/guides/gs/rest-service/ </br>
Next: refer "See Also" section of https://spring.io/guides/gs/consuming-rest/</br>
Next: refer "Summary" and "See Also" sections of https://spring.io/guides/gs/accessing-data-jpa/</br>
