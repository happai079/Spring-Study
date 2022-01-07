package com.di.spring_di_xml_constructor_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {
	// TV Main - TV 클레스에서 정의해 놓은 메서드 사용
	public static void main(String[] args) {
		// 스프링 컨테이너 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2.xml");
		
		// 컨테이너에서 빈(컴포넌트) 가져옴
		TV tv = context.getBean("tv", TV.class);
		tv.volumeUp();
		tv.volumeDown();
		
		context.close();
	}

}
