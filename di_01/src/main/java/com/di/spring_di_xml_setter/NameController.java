package com.di.spring_di_xml_setter;

public class NameController {
	NameService nameService;

	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
