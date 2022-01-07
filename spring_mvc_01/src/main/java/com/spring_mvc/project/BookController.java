package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	// Model 사용
	@RequestMapping("/bookInfoView1")
	public String showBookInfo1(Model model) {
		model.addAttribute("title", "스프링 프레임워크");
		model.addAttribute("price", 20000);
		return "book/bookInfoView";
	}

	// ModelAndView 사용
	@RequestMapping("/bookInfoView2")
	public ModelAndView showBookInfo2(ModelAndView mv) {
		mv.addObject("title", "자바의 정석");
		mv.addObject("price", 35000);
		mv.setViewName("book/bookInfoView");
		return mv;
	}
	
	// 다중 매핑
	@RequestMapping(value = {"/bookInfoView3", "/bookInfoView4"})
	public String showBookInfo34(HttpServletRequest request, Model model) {
		if(request.getServletPath().equals("/bookInfoView3")) {
			model.addAttribute("title", "영어 회화");
			model.addAttribute("price", 30000);
		}else if(request.getServletPath().equals("/bookInfoView4")) {
			model.addAttribute("title", "수학 정석");
			model.addAttribute("price", 40000);
		}
		
		return "book/bookInfoView";
	}
}
