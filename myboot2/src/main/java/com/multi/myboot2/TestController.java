package com.multi.myboot2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	// JSP 페이지 없이 응답 문서를 body에 출력
	/* @ResponseBody
	@RequestMapping("/")
	public String home() {
		return "myboot02";
	}*/
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
