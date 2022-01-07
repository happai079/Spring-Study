package com.aop.spring_aop_xml;

// 핵심 기능 수행
public class Rect {
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void showResult() {
		System.out.println("넓이: " + (width * height));
		System.out.println("둘레: " + (2 * (width + height)));
	}
}
