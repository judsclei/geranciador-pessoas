package com.afvb.personApiExample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PersonApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApiExampleApplication.class, args);
	}

}
