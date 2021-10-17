package capg.poc.PassengerService;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SuppressWarnings("deprecation")
@EnableMongoRepositories
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
//@EnableHystrixDashboard
//@EnableCircuitBreaker

public class PassengerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassengerServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Passenger Service",
				"Passenger Service for Flight Booking System",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Simran Arora", "https://www.samplewebsite.com", "id@mail.com"),
				"API License",
				"https://www.samplewebsite.com",
				Collections.emptyList()
		);
	}
}
