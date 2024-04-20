package com.zoggy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineFoodOrderingApplication {

	public static void main(String[] args) {
//		@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
		SpringApplication.run(OnlineFoodOrderingApplication.class, args);
	}

}
