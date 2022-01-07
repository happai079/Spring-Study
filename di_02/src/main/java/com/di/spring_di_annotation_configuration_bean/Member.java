package com.di.spring_di_annotation_configuration_bean;

import java.util.ArrayList;

public class Member {
	private BMI bmi;
	private String name;
	private int age;
	private float height;
	private float weight;
	private ArrayList<String> courses;
	
	// Setter 기반 DI : 매개변수가 있는 생성자 있으면 안 됨

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
