package com.di.spring_di_xml_constructor_value;

import java.util.ArrayList;

public class Member {
	private BMI bmi;
	private String name;
	private int age;
	private float height;
	private float weight;
	private ArrayList<String> courses;
	
	// 생성자 기반 DI : BMI bmi 
	public Member(BMI bmi, String name, int age, float height, float weight, ArrayList<String> courses) {
		this.bmi = bmi;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.courses = courses;
	}

	public BMI getBmi() {
		return bmi;
	}

	public void setBmi(BMI bmi) {
		this.bmi = bmi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
	
	public void showBMI() {
		bmi.showBMI(height, weight);
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + ", courses="
				+ courses + "]";
	}
	
}
