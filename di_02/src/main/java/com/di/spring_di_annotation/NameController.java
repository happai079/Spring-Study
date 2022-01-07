package com.di.spring_di_annotation;

import javax.annotation.Resource;

public class NameController {
	
	/* 
	 * 어노테이션 사용하여 빈을 자동으로 주입 
	 * @Autowired - 해당 타입의 빈을 찾아서 필드(변수)에 할당
	 * @Qualifier("bNameService") - 동일한 interface를 구현한 클래스가 여러 개 있는 경우
	 * @Resource(name="anotherNameService")
	 */	
	
	// 인터페이스 타입으로 선언 
	@Resource() // 필드명과 동일한 id을 가진 빈을 주입
	INameService nameService;
	
	// Setter 사용한 DI
	public void setNameService(INameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
