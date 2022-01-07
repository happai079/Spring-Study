package com.di.spring_di_annotation_component2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// NameController 클래스를 빈으로 등록
// 생성된 빈 이름은 nameController
// NameMain에서 사용
@Controller
public class NameController {
	@Autowired
	INameService nameService;
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
