package com.careerit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
@EnableCaching
public class SpringbootCicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCicdApplication.class, args);
	}

}
