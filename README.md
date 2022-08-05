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

https://spring.io/guides/gs/accessing-data-jpa/</br>
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

Next: refer "See Also" section of https://spring.io/guides/gs/rest-service/ </br>
Next: refer "See Also" section of https://spring.io/guides/gs/consuming-rest/</br>

#
#

[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.</br>
[ERROR] Re-run Maven using the -X switch to enable full debug logging.

- mvn -e -X spring-boot:run
