package com.ai.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.ex.service.CFRCelebrityService;

@Controller
public class AIController {
	@Autowired
	private CFRCelebrityService cfrServiceCel;
	
	@RequestMapping("/")
	public String indexView() {
		return "index";
	}
	
	@RequestMapping("/faceRecogCel")
	public String faceRecogCel() {
		cfrServiceCel.clovaFaceRecogCel();
		return "celebrityView";
	}
}
