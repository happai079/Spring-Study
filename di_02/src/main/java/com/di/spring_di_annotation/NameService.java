package com.di.spring_di_annotation;

public class NameService implements INameService {

	@Override
	public String showName(String name) {
		System.out.println("NameService showName() 메서드");
		String myName = "내 이름은 " + name + "입니다.";
		return myName;
	}

}
