package com.mycompany.dvdstore.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
@EntityScan(basePackages = "com.mycompany.dvdstore.core.entity.movie")
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
	
	@Bean
	public Hibernate5Module datatypeHibernateModule()
	{
		Hibernate5Module module = new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		return module;
	}
	
	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}

}
