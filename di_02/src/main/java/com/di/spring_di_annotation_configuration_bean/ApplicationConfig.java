package com.di.spring_di_annotation_configuration_bean;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// xml 설정 파일의 역할을 하는 클래스
@ComponentScan("com.di.spring_di_annotation_configuration_bean")
@Configuration
public class ApplicationConfig {
	// 빈 설정
	@Bean
	public BMI bmi() {
		BMI bmi = new BMI();
		return bmi;
	}
	
	@Bean
	public Member member() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("수영");
		courses.add("헬스");
		courses.add("에어로빅");
		
		Member member = new Member();
		member.setBmi(bmi());
		member.setName("홍길동");
		member.setAge(20);
		member.setHeight(170);
		member.setWeight(70);
		member.setCourses(courses);
		
		return member;
	}
}
