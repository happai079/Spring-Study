package com.ai.ex.model;

public class CelebrityVO {
	private String value;		// 연예인 이름
	private double confidence;	// 정확성
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
}
