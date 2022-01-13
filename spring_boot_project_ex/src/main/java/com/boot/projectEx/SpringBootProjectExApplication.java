package com.boot.projectEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.boot.projectEx.controller.MemberController;

@SpringBootApplication
@ComponentScan(basePackageClasses = MainController.class)
@ComponentScan(basePackageClasses = MemberController.class)
public class SpringBootProjectExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectExApplication.class, args);
	}

}
