package com.atlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
@EnableScheduling
public class AtlasdataApplication {
	public static void main(String[] args) {

		SpringApplication.run(AtlasdataApplication.class, args);
	}
}
