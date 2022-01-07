package com.di.no_spring_no_di;

public class NameController {
	// 원하는 곳에서 new 연산자를 사용해서 객체 직접 생성
	// 의존성을 존재하나 DI는 아님
	NameService nameService = new NameService();
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
