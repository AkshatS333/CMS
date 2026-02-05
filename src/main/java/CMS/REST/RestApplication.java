package CMS.REST;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info= @Info(
			title= "Content Management System",
			description = "A modular, developer-friendly CMS backend in Spring Boot that exposes clean RESTful APIs, OpenAPI documentation, and easy adapters for different storage backends. Emphasizes testability, clear separation of concerns, and extensibility to speed developer onboarding and integrations with modern frontend stacks.",
			version="v1.0",
			contact = @Contact(
					name = "Akshat",
					email = "akprofessor333@gmail.com"
			)

	),
	externalDocs = @ExternalDocumentation(
		description = "CMS App Documentation",
		url = "https://github.com/AkshatS333"
	)
)
public class RestApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	} 

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
