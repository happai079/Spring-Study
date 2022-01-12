package com.multi.myboot02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.multi.product.IProductDAO;
import com.multi.product.ProductController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ProductController.class)
@MapperScan(basePackageClasses = IProductDAO.class)
public class Myboot02Application {

	public static void main(String[] args) {
		SpringApplication.run(Myboot02Application.class, args);
	}

}
