package com.verinite.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableEurekaClient
public class BookApplication extends SpringBootServletInitializer {
	
    private static final Logger LOGGER = LogManager.getLogger(BookApplication.class);
       
    @Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
    
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(BookApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
//        
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
//        System.out.println("Info level log message");

//        LOGGER.error("Error level log message");
	}

	
}
