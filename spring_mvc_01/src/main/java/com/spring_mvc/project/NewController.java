package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	// '/newView'로 요청이 들어오면 처리
	@RequestMapping("/newView")
	public String newView() {
		return "newView";  // 뷰 페이지 이름 반환
		// 뷰 페이지 이름 앞에 아무것도 없으면 폴더가 views
	}
	
	//	뷰 페이지로 데이터 전달
	// '/showInfo' 요청이 들어오면
	// Model 객체를 이용하여 데이터 설정
	// showInfo 뷰 페이지로 객체 전달
 	@RequestMapping("/showInfo")
	public String showInfo(Model model) {
 		model.addAttribute("name", "홍길동");
 		model.addAttribute("age", 30);
 		return "showInfo";
 	}
	
 	
 	// ModelAndView 클래스 사용
 	// 데이터, 뷰 둘다 설정
 	// ModelAndView 객체 반환
 	@RequestMapping("/showInfo2")
 	public ModelAndView showInfo2(ModelAndView mv) {
 		// 데이터 설정
 		mv.addObject("name", "이몽룡");
 		mv.addObject("address", "서울");
 
 		// 뷰 페이지 설정
 		mv.setViewName("showInfo2");
 		
 		return mv;
 	}
 	
 	// Model과 ModelAndView 두개 사용
 	@RequestMapping("/showInfo3")
 	public ModelAndView showInfo3(Model model, ModelAndView mv) {

 		model.addAttribute("name", "이몽룡");
 		
 		mv.addObject("name", "성춘향");
 		mv.addObject("age", 20);
 		mv.setViewName("showInfo3");
 		
 		model.addAttribute("address", "남원");
 		
 		return mv;
 	}
}
