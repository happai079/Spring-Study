package com.ai.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ai.ex.controller.AIController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ai.ex"})
@ComponentScan(basePackageClasses = AIController.class)
public class NaverAiPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverAiPlatformApplication.class, args);
	}

}
