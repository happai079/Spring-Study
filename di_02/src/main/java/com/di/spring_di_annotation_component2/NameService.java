package com.di.spring_di_annotation_component2;

import org.springframework.stereotype.Service;

// NameService 클래스를 빈으로 등록
// 생성된 빈 이름은 nameService
// NameController에서 사용
@Service
public class NameService implements INameService {

	@Override
	public String showName(String name) {
		System.out.println("NameService showName() 메서드");
		String myName = "내 이름은 " + name + "입니다.";
		return myName;
	}

}
