package com.boot.projectEx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// index 페이지 이동
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
