package com.di.no_spring_di_constructor;

public class NameController {
	// 생성자를 통해서 NameService 객체를 전달 받음
	// - 생성자를 통해서 외부에서 주입받음 : 의존성 주입
	
	// 멤버 변수 설정
	NameService nameService;
	
	public NameController(NameService nameService) {
		// 전달받은 값으로 멤버변수 초기화
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
