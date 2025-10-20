package br.edu.ifsp.provaPRW3.api_2025_bes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Api2025BesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Api2025BesApplication.class, args);
	}

}
