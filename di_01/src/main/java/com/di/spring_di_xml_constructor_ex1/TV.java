package com.di.spring_di_xml_constructor_ex1;

public class TV {
	// 다형성 개념 - speaker객체를 TV에서 사용 
	Speaker speaker;
	
	// di(의존성 주입) - 생성자 사용
	public TV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
