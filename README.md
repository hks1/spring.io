# spring.io
spring.io

## demo

~~https://spring.io/quickstart~~</br>
- spring boot
  - import _org.springframework.boot.SpringApplication_;
  - import _org.springframework.boot.autoconfigure.SpringBootApplication_;
  - import _org.springframework.context.annotation.ComponentScan_;
- spring web

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
Next: refer "See Also" section of https://spring.io/guides/gs/rest-service/ </br>
Next: refer "See Also" section of https://spring.io/guides/gs/consuming-rest/</br>
