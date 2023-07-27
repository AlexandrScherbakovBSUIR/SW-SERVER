package edu.easysoft.swserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("service")
@ComponentScan("controller")
public class SwServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwServerApplication.class, args);
	}

}
